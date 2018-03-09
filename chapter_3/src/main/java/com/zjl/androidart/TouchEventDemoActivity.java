package com.zjl.androidart;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by zjl on 18-3-9.
 *
 * 针对view的disable的熟悉是否影响view接收事件进行验证
 * 根据1：如果事件没有被disable的button消费，就会传递给上层处理，最终回调Activity#onTouchEvent().
 * 根据2：因为普通的TextView不消费事件，如果点击textView,最终会回调Activity#onTouchEvent().
 * 验证：disable不会影响onTouchEvent的默认返回值，即是否消费事件，这个值根据CLICKABLE计算而来。
 *      如果一个button是disable，它还是会消费事件，只是，没有针对事件进行处理-->没有调用onTouch/onClick.
 */

public class TouchEventDemoActivity extends Activity{

    private Button disableBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);
        initViews();
    }

    private void initViews() {
        disableBtn = findViewById(R.id.btn);
        disableBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                System.out.println("...button...onTouch...");
                /*
                onTouch在onTouchEvent()之前调用，这里必须返回false，onTouchEvent()才会调用
                onClick()才有可能执行。
                 */
                return false;
            }
        });

        disableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("...button...onClick...");
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        /*
        如果所有view都不消费点击事件，点击时间会回到Activity，由Activity消费
         */
        System.out.println("Activity...... onTouchEvent...");
        return super.onTouchEvent(event);
    }
}
