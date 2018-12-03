package com.example.zhoukaoyi.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zhoukaoyi.R;

public class MyXHView extends LinearLayout {

    private final EditText mEditText;
    private final TextView mCancel;

    public MyXHView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.header_view,this);
        mEditText = findViewById(R.id.Search_Edit);
        mCancel = findViewById(R.id.Cancel_Text);
    }
    public String getEditStr(){
        return mEditText.getText().toString();
    }
    public TextView getmCancel(){
        return mCancel;
    }


}
