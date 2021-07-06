package com.hsiung.androidlearn.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hsiung.androidlearn.R;
import com.hsiung.androidlearn.util.ToastUtil;

public class ToastActivity extends AppCompatActivity {

    private final Context mContext = this;

    private Button mBtnDefault;
    private Button mBtnChangeLocation;
    private Button mBtnCustomize;
    private Button mBtnUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        mBtnDefault = findViewById(R.id.btn_default_toast);
        mBtnChangeLocation = findViewById(R.id.btn_change_location_toast);
        mBtnCustomize = findViewById(R.id.btn_customize_toast);
        mBtnUtil = findViewById(R.id.btn_util_toast);

        setListener();

    }

    private void setListener() {
        OnClick onClick = new OnClick();
        mBtnDefault.setOnClickListener(onClick);
        mBtnChangeLocation.setOnClickListener(onClick);
        mBtnCustomize.setOnClickListener(onClick);
        mBtnUtil.setOnClickListener(onClick);
    }


    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.btn_default_toast) {
                // 默认样式Toast
                Toast.makeText(mContext, "这是默认Toast样式！", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.btn_change_location_toast) {
                // 改变位置的Toast
                Toast toastCenter = Toast.makeText(mContext, "居中显示Toast", Toast.LENGTH_SHORT);
                toastCenter.setGravity(Gravity.CENTER, 0, 0);
                toastCenter.show();
            } else if (id == R.id.btn_customize_toast) {
                // 自定义Toast
                Toast toastCustomize = new Toast(mContext);
                LayoutInflater inflater = LayoutInflater.from(mContext);
                View view = inflater.inflate(R.layout.layout_customize_toast, null);
                ImageView imageView = view.findViewById(R.id.iv_toast);
                TextView textView = view.findViewById(R.id.tv_toast);
                imageView.setImageResource(R.drawable.ic_toast);
                textView.setText("自定义Toast！");
                toastCustomize.setView(view);
                toastCustomize.setDuration(Toast.LENGTH_SHORT);
                toastCustomize.show();
            } else if (id == R.id.btn_util_toast) {
                ToastUtil.showMsg(mContext, "包装过的Toast！");

            }
        }
    }
}