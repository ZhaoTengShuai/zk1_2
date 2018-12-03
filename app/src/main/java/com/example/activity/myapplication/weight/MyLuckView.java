package com.example.activity.myapplication.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Toast;

import java.util.Random;

public class MyLuckView extends View implements View.OnClickListener{



    private String[] contents = new String[]{"伍 元", "重 来", "拾 元", "零 元", "贰 拾", "滚 蛋"};
    public int[] colors = new int[]{Color.parseColor("#8EE5EE"), Color.parseColor("#FFD700"), Color.parseColor("#FFD39B"), Color.parseColor("#FF8247"), Color.parseColor("#FF34B3"), Color.parseColor("#F0E68C")};
    private int mWidth;
    private Paint mPaint;
    private Context mContext;
    private String mStr="start";

    public MyLuckView(Context context,AttributeSet attrs) {
        super(context, attrs);
       mContext=context;
       mPaint=new Paint();
     setOnClickListener(this);
    }




    //会发生覆盖效果
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.YELLOW);
        mPaint.setStyle(Paint.Style.STROKE);
        //设置边缘锯齿
        mPaint.setAntiAlias(true);
        //描边宽度
        mPaint.setStrokeWidth(3);
        canvas.drawCircle(mWidth /2,mWidth/2,mWidth/2,mPaint);

        //因为要画扇形 里面有个Rectf
        //因为那个圆其实是站全屏的，所以我这个Rectfde 空间也是全屏
        RectF rectF=new RectF(0,0,mWidth,mWidth);
        mPaint.setStyle(Paint.Style.FILL);
        for (int i=0;i<colors.length;i++){
            mPaint.setColor(colors[i]);
            int startjb=i*60;
            canvas.drawArc(rectF,startjb,60,true,mPaint);
        }

        //填充文字
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(24);

        for (int i=0;i<contents.length;i++){
            int startjb=i*60;
            //Path 代表路径 想怎么画就怎么画
            Path path=new Path();
            path.addArc(rectF,startjb,60);
            canvas.drawTextOnPath(contents[i],path,50,50,mPaint);
        }

        //画内圆
        mPaint.setColor(Color.RED);
      canvas.drawCircle(mWidth/2,mWidth/2,50,mPaint);

      mPaint.setColor(Color.BLACK);
      mPaint.setTextSize(24);

        Rect rect=new Rect();
        mPaint.getTextBounds(mStr,0,mStr.length(),rect);
        int width = rect.width();
        int height = rect.height();
  canvas.drawText(mStr,mWidth/2-width/2,mWidth/2+height/2,mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       setMeasuredDimension(300,300);
        mWidth=getMeasuredWidth();
    }


    @Override
    public void onClick(View v) {

        Toast.makeText(mContext,"转盘",Toast.LENGTH_SHORT).show();

        Random random=new Random();
        float jb = random.nextInt(3600);

        RotateAnimation rotateAnimation=new RotateAnimation(0f, jb,mWidth/2,mWidth/2);
        rotateAnimation.setDuration(3000);
        //保留最后执行完的位置
   rotateAnimation.setFillAfter(true);
startAnimation(rotateAnimation);
    }
}
