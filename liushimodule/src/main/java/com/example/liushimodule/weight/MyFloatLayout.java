package com.example.liushimodule.weight;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.liushimodule.R;

public class MyFloatLayout extends LinearLayout {
    private int mScreenWidth;
    public MyFloatLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics metrics=context.getResources().getDisplayMetrics();
        mScreenWidth= metrics.widthPixels;
        //设置布局显示垂直显示
        setOrientation(VERTICAL);
    }

    public void setData(String[] data){
        LinearLayout  linearLayout=getLin();

        for (int i = 0; i <data.length ; i++) {
            String tmp=data[i];
            int numWidth=0;
            //得到一行LinearLayout到底有多少子控件  因为要计算每个子控件加在一起的宽度
            int childCount= linearLayout.getChildCount();
            //这个for循环只是计算一个LinearLayout的所有的子控件的宽和高
            for (int j = 0; j <childCount; j++) {
                //得到每一个子控件
                TextView tv = (TextView) linearLayout.getChildAt(j);
                LayoutParams layoutParams = (LayoutParams) tv.getLayoutParams();
                int leftMargin=layoutParams.leftMargin;
                //测量这个TV的宽和高
                tv.measure(getMeasuredWidth(),getMeasuredHeight());
                numWidth+=tv.getMeasuredWidth()+leftMargin+tv.getPaddingLeft()+getPaddingRight();
            }
            TextView dataText=getText();
            //设置属性
            LayoutParams params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            params.leftMargin=10;
            params.topMargin=2;
            dataText.setLayoutParams(params);
            dataText.setText(tmp);
            dataText.measure(getMeasuredWidth(),getMeasuredHeight());
            int dataTextWidth=dataText.getMeasuredWidth()+dataText.getPaddingLeft()+dataText.getPaddingRight();
            //考虑到一个字符串很长 就直接超过整个屏幕的长了
            if(dataTextWidth>=mScreenWidth){
                String s = tmp.substring(0, 4);
                dataText.setText(s+"...");
                dataText.measure(getMeasuredWidth(),getMeasuredHeight());
                dataTextWidth=dataText.getMeasuredWidth();
            }

            if(mScreenWidth>=numWidth+dataTextWidth){
                linearLayout.addView(dataText);
            }else{
                linearLayout=getLin();
                linearLayout.addView(dataText);
            }
        }


    }
    //初始化子LinearLayout
    private LinearLayout getLin(){
        LinearLayout linearLayout=new LinearLayout(getContext());
        //控制组件大小的一个工具LayoutParams
        LayoutParams params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(params);
        //this本类对象
        this.addView(linearLayout);
//只要重新添加view了自动换行
        return  linearLayout;
    }

    private TextView getText(){
        TextView textView=new TextView(getContext());
        textView.setTextSize(20);
        textView.setTextColor(Color.BLACK);
        textView.setBackgroundResource(R.drawable.shape);
        textView.setPadding(10,10,10,10);
        return  textView;

    }

}
