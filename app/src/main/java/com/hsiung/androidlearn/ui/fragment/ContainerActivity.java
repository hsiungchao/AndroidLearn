package com.hsiung.androidlearn.ui.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.hsiung.androidlearn.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick {

    private TextView mTvHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        // 实例化AFragment
//        mAFragment = new AFragment();
        AFragment aFragment = AFragment.newInstance("我是参数");
        // 把AFragment添加到Activity中
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl_container, aFragment, "a")
                .commitAllowingStateLoss();

        mTvHello = findViewById(R.id.tv_hello);
    }

    @Override
    public void onClick(String msg) {
        mTvHello.setText(msg);
    }
}