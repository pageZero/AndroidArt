package com.zjl.androidart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView titleTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        //手指移动可识别的最小距离
        int touchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        System.out.println("touchslop:" + touchSlop);
    }

    private void initViews() {
        titleTv = findViewById(R.id.title_tv);
        LinearLayout linearLayout
    }

    /*
    1. 在onWindowFocusChange中获取控件位置
    该方法回调的时候，表示View已经初始化完成了
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            /*
            left,top,right,bottom是一组位置参数
            left:view的左上角到父View左边界的距离
            top:view的右上角到父view上边界的距离
             */
            int left = titleTv.getLeft();
            int top = titleTv.getTop();
            int right = titleTv.getRight();
            int bottom = titleTv.getBottom();

            /*
            x,y,translationX,translationY
            x,y是view左上角的坐标，不发生偏移时，和left,top值相同
            translationX：x方向上的偏移量
            translationY：Y方向上的偏移量
            x = left + translationX
             */
            float x = titleTv.getX();
            float y = titleTv.getY();
            float translationX = titleTv.getTranslationX();
            float translationY = titleTv.getTranslationY();

            System.out.println("left=" + left);
            System.out.println("top=" + top);
            System.out.println("right=" + right);
            System.out.println("bottom=" + bottom);
            System.out.println("x=" + x);
            System.out.println("y=" + y);
            System.out.println("translationX=" + translationX);
            System.out.println("translationY=" + translationY);

            titleTv.setTranslationX(50);

            left = titleTv.getLeft();
            top = titleTv.getTop();
            right = titleTv.getRight();
            bottom = titleTv.getBottom();

            //x,y,translationX,translationY
            x = titleTv.getX();
            y = titleTv.getY();
            translationX = titleTv.getTranslationX();
            translationY = titleTv.getTranslationY();

            System.out.println("left=" + left);
            System.out.println("top=" + top);
            System.out.println("right=" + right);
            System.out.println("bottom=" + bottom);
            System.out.println("x=" + x);
            System.out.println("y=" + y);
            System.out.println("translationX=" + translationX);
            System.out.println("translationY=" + translationY);


        }
    }
}
