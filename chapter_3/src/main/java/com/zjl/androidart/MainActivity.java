package com.zjl.androidart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView titleTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        titleTv = findViewById(R.id.title_tv);
    }

    /*
    1. 在onWindowFocusChange中获取控件位置
    该方法回调的时候，表示View已经初始化完成了
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            //left,top,right,bottom是一组位置参数
            int left = titleTv.getLeft();
            int top = titleTv.getTop();
            int right = titleTv.getRight();
            int bottom = titleTv.getBottom();

            //x,y,translationX,translationY
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
        }
    }
}
