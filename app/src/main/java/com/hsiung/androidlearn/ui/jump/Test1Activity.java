package com.hsiung.androidlearn.ui.jump;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hsiung.androidlearn.R;
import com.hsiung.androidlearn.util.ToastUtil;

public class Test1Activity extends AppCompatActivity {

    private static final String TAG = "Test1Activity";
    private final Context mContext = this;

    private Button mBtnJump;
    private Button mBtnStartMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        Log.d(TAG, "---onCreate---");
        Log.d(TAG, "taskId: " + getTaskId() + ", hash: " + this.hashCode());
        logTaskName();

        mBtnJump = findViewById(R.id.btn_jump);
        mBtnStartMode = findViewById(R.id.btn_start_mode);

        setListener();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ToastUtil.showMsg(mContext, data.getExtras().getString("title"));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "----onNewIntent----");
        Log.d(TAG, "taskId: " + getTaskId() + ", hash: " + hashCode());
        logTaskName();
    }

    private void setListener() {
        OnClick onClick = new OnClick();
        mBtnJump.setOnClickListener(onClick);
        mBtnStartMode.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            int id = v.getId();
            if (id == R.id.btn_jump) {
                // 显示调用1
                intent = new Intent(mContext, Test2Activity.class);
                // 使用Bundle传递数据给下一个Activity
                Bundle bundle = new Bundle();
                bundle.putString("name", "熊超");
                bundle.putInt("age", 26);
                intent.putExtras(bundle);
                startActivity(intent);
//                startActivityForResult(intent, 0);
                // 显示调用2
//                intent = new Intent();
//                intent.setClass(mContext, Test2Activity.class);
//                startActivity(intent);
                // 显示调用3
//                intent = new Intent();
//                intent.setClassName(mContext, "com.hsiung.androidlearn.jump.Test2Activity");
//                startActivity(intent);
                // 显示调用4
//                intent = new Intent();
//                intent.setComponent(new ComponentName(mContext, "com.hsiung.androidlearn.jump.Test2Activity"));
//                startActivity(intent);
                // 隐式调用
//                intent = new Intent();
//                intent.setAction("android.intent.action.CUSTOM");
//                startActivity(intent);
            } else if (id == R.id.btn_start_mode) {
                intent = new Intent(mContext, Test1Activity.class);
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