package com.hsiung.androidlearn.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hsiung.androidlearn.R;
import com.hsiung.androidlearn.util.ToastUtil;

public class ButtonActivity extends AppCompatActivity {

    private Context mContext = this;

    private Button mBtn3;
    private TextView mTv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        mBtn3 = findViewById(R.id.btn_3);
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this, "按钮3：我被点击了", Toast.LENGTH_SHORT).show();
//                ToastUtil.showMsg(mContext, "按钮3：我被点击了");

            }
        });

        mTv1 = findViewById(R.id.btn_tv1);
        mTv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this, "文字1：我被点击了", Toast.LENGTH_SHORT).show();
//                ToastUtil.showMsg(mContext, "文字1：我被点击了");
            }
        });
    }

    public void showToast(View view){
        Toast.makeText(this, "按钮4：我被点击了", Toast.LENGTH_SHORT).show();
//        ToastUtil.showMsg(mContext, "按钮4：我被点击了");
    }
}