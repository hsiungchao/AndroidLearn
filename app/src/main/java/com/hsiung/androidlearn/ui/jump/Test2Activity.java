package com.hsiung.androidlearn.ui.jump;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hsiung.androidlearn.R;

public class Test2Activity extends AppCompatActivity {


    private static final String TAG = "Test2Activity";

    private TextView mTvInformation;
    private Button mBtnFinish;
    private Button mBtnStartMode;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        Log.d(TAG, "---onCreate---");
        Log.d(TAG, "taskId: " + getTaskId() + ", hash: " + hashCode());
        logTaskName();

        mTvInformation = findViewById(R.id.tv_information);
        // 使用上一个Activity传递过来的数据
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        int age = bundle.getInt("age");
        mTvInformation.setText("name:" + name + ";age" + age);

        mBtnFinish = findViewById(R.id.btn_finish);
        mBtnStartMode = findViewById(R.id.btn_start_mode);

        OnClick onClick = new OnClick();

        mBtnFinish.setOnClickListener(onClick);
        mBtnStartMode.setOnClickListener(onClick);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Log.d(TAG, "onNewIntent: ");
        Log.d(TAG, "---onNewIntent---");
        Log.d(TAG, "taskId: " + getTaskId() + ", hash: " + hashCode());
        logTaskName();
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            int id = v.getId();
            if (id == R.id.btn_finish) {
                intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("title", "我回来了");
                intent.putExtras(bundle);
                setResult(Activity.RESULT_OK, intent);
                finish();
            } else if (id == R.id.btn_start_mode) {
                intent = new Intent(Test2Activity.this, Test1Activity.class);
                startActivity(intent);
            }
        }
    }

    private void logTaskName() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d(TAG, info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}