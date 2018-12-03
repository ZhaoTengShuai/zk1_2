package com.example.zhoukaoyi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.zhoukaoyi.dao.MyDao;
import com.example.zhoukaoyi.weight.MyFloatLayout;
import com.example.zhoukaoyi.weight.MyXHView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   // private String[] data = {"流感", "咳嗽", "过敏", "发烧", "感冒", "湿疹", "便秘", "痔疮", "协和", "鼻炎", "失眠", "痛风", "上火", "脚气", "抑郁症", "性欲", "乳腺增生", "头晕", "腰痛"};
   private String[] data={"考拉三周年人气热销榜","电动牙刷","尤妮佳","豆豆鞋","沐浴露","日东红茶","榴莲"};
    private MyXHView header_View;
    private TextView Delete_Text;
    private MyFloatLayout mHistoryLayout;
   private ArrayList<String> mList=new ArrayList<>();
   private ArrayList<String>mHistoy=new ArrayList<>();
    private MyFloatLayout myFloatLayout;
    private MyDao myDao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDao = new MyDao(this);
        mHistoy= myDao.selectName();
        initData();
        initView();
        if(!mHistoy.isEmpty()){
            mHistoryLayout.setData(mHistoy);
        }
    }
    private void initData(){
        for (int i = 0; i <data.length ; i++) {
            mList.add(data[i]);
        }
    }
    private void initView() {
        header_View = (MyXHView) findViewById(R.id.header_View);
        header_View.getmCancel().setOnClickListener(this);
        Delete_Text = (TextView) findViewById(R.id.Delete_Text);
        Delete_Text.setOnClickListener(this);
        mHistoryLayout = (MyFloatLayout) findViewById(R.id.MyFloat_Layout_History);

        myFloatLayout = findViewById(R.id.MyFloat_Layout);
        myFloatLayout.setData(mList);
    }

    @Override
    public void onClick(View v) {

    switch (v.getId()){
        case R.id.Cancel_Text:
          String name=  header_View.getEditStr().trim();
          myDao.insertSqlite(header_View.getEditStr().trim());
          mHistoryLayout.removeChildView();
          mHistoy.add(name);
          mHistoryLayout.setData(mHistoy);

          break;
        case R.id.Delete_Text:
           mHistoy.clear();

    mHistoryLayout.removeChildView();
            break;
    }
    }
}
