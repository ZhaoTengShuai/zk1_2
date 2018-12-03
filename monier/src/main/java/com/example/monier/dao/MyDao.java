package com.example.monier.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.monier.helper.MyHelper;

import java.util.ArrayList;

public class MyDao {

    private MyHelper helper;
    private SQLiteDatabase mData;
    private Context mContext;

    public MyDao(Context context) {
        mContext = context;
        helper = new MyHelper(context);
        mData = helper.getWritableDatabase();
    }


    public void insertSqlite(String name) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        mData.insert("liu", null, contentValues);
        Toast.makeText(mContext, "插入成功", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<String> selectName() {
        ArrayList<String> list = new ArrayList<>();
        Cursor cursor = mData.query("liu", null, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            list.add(name);
        }
        return list;
    }

    public void delete() {
        mData.execSQL("delete from liu");
    }
}
