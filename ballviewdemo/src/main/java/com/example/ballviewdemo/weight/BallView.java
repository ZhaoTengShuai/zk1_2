package com.example.ballviewdemo.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class BallView extends View {
       //private int mWidth;
       private  Paint mPaint;
       private float x=100;
       private float y=100;

    public BallView(Context context,AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

     //mPaint.setStyle(Paint.Style.FILL);
canvas.drawCircle(x,y,100,mPaint);
    }

   /* @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        setMeasuredDimension(300,300);
        mWidth=getMeasuredWidth();
    }*/

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
                case MotionEvent.ACTION_MOVE:
                    x=event.getX();
                    y=event.getY();
                    invalidate();
                    break;
            case MotionEvent.ACTION_UP:
                break;
        }

        return true;
    }
}
