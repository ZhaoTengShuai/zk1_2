package com.example.myliuview.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.RotateAnimation;

import java.util.Random;

public class MyView extends View implements View.OnClickListener{
    private String[] contents =new String[]{"伍 元", "重 来", "拾 元", "零 元", "贰 拾", "滚 蛋"};
    public int[] colors = new int[]{Color.parseColor("#8EE5EE"), Color.parseColor("#FFD700"), Color.parseColor("#FFD39B"), Color.parseColor("#FF8247"), Color.parseColor("#FF34B3"), Color.parseColor("#F0E68C")};
  private int mWidth;
  private Paint mPaint;
  private String str="start";
    public MyView(Context context,  AttributeSet attrs) {
        super(context, attrs);

        mPaint=new Paint();
        setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

       mPaint.setColor(Color.YELLOW);
       mPaint.setStyle(Paint.Style.STROKE);
       mPaint.setAntiAlias(true);
       mPaint.setStrokeWidth(3);
       canvas.drawCircle(mWidth/2,mWidth/2,mWidth/2,mPaint);
        RectF rectF=new RectF(0,0,mWidth,mWidth);
      mPaint.setStyle(Paint.Style.FILL);

      for(int i=0;i<colors.length;i++){
          mPaint.setColor(colors[i]);
          int recjb=i*60;
          canvas.drawArc(rectF,recjb,60,true,mPaint);
      }

      mPaint.setColor(Color.BLACK);
       mPaint.setTextSize(24);
       for(int i=0;i<contents.length;i++){
           int recjb=i*60;
           Path path=new Path();
          path.addArc(rectF,recjb,60);
           canvas.drawTextOnPath(contents[i],path,60,60,mPaint);

       }

       mPaint.setColor(Color.BLUE);
       canvas.drawCircle(mWidth/2,mWidth/2,50,mPaint);

       mPaint.setColor(Color.BLACK);
      mPaint.setTextSize(24);
        Rect rect=new Rect();

      mPaint.getTextBounds(str,0,str.length(),rect);
        int width = rect.width();
        int height = rect.height();
       canvas.drawText(str,mWidth/2-width/2,mWidth/2+height/2,mPaint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       setMeasuredDimension(300,300);
       mWidth=getMeasuredWidth();
    }

    @Override
    public void onClick(View v) {
        Random random=new Random();
        float jb = random.nextInt(720);
        RotateAnimation rotateAnimation=new RotateAnimation(0f,jb,mWidth/2,mWidth/2);
        rotateAnimation.setDuration(3000);

        rotateAnimation.setFillAfter(true);
        startAnimation(rotateAnimation);
    }
}
