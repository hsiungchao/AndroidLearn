package com.hsiung.androidlearn.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.hsiung.androidlearn.R;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBox mCbProgram;
    private CheckBox mCbCook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        mCbProgram = findViewById(R.id.cb_program);
        mCbCook = findViewById(R.id.cb_cook);

        mCbProgram.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this, isChecked ? "选中编程" : "取消选中编程", Toast.LENGTH_SHORT).show();
            }
        });

        mCbCook.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this, isChecked ? "选中做饭" : "取消选中做饭", Toast.LENGTH_SHORT).show();
            }
        });
    }
}