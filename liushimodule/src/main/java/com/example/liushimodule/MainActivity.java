package com.example.liushimodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.liushimodule.weight.MyFloatLayout;

public class MainActivity extends AppCompatActivity {
    private String[] data = {"lvxx", "lgqflvxxlvxxlvxxlvxxlvxxlvxxlvxxlvxxlvxxlvxxlvxxlgqflvxxlvxxlvxxlvxxlvxxlvxxlvxxlvxxlvxxlvxxlvxxlvxxlvxxlvxxlvxxlvxxlvxxlvxxlvxxlvxxlvxxlvxx", "heheda", "memeda", "papapa", "lgqf", "heheda", "memeda", "papapa", "lgqf", "heheda", "memeda", "papapa", "lgqf", "heheda", "memeda", "papapa", "lgqf", "heheda", "memeda", "papapa"};
    private MyFloatLayout myFloatLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myFloatLayout = findViewById(R.id.MyFloat);
        myFloatLayout.setData(data);
    }
}
