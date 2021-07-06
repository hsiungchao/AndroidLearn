package com.hsiung.androidlearn.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.hsiung.androidlearn.R;
import com.hsiung.androidlearn.util.ToastUtil;

public class ProgressActivity extends AppCompatActivity {

    private final Context mContext = this;

    private ProgressBar mPbHorizontalOldStyle;
    private Button mBtnStart;
    private Button mBtnProgressDialog1;
    private Button mBtnProgressDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        mPbHorizontalOldStyle = findViewById(R.id.pb_horizontal_old_style);
        mBtnStart = findViewById(R.id.btn_start);
        mBtnProgressDialog1 = findViewById(R.id.btn_progress_dialog1);
        mBtnProgressDialog2 = findViewById(R.id.btn_progress_dialog2);

        setListener();

    }

    private void setListener() {
        OnClick onClick = new OnClick();
        mBtnStart.setOnClickListener(onClick);
        mBtnProgressDialog1.setOnClickListener(onClick);
        mBtnProgressDialog2.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.btn_start) {
                handler.sendEmptyMessage(0);
            } else if (id == R.id.btn_progress_dialog1) {
                ProgressDialog progressDialog = new ProgressDialog(mContext);
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在加载");
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ToastUtil.showMsg(mContext, "cancel...");
                    }
                });
//                progressDialog.setCancelable(false);
                progressDialog.show();
            } else if (id == R.id.btn_progress_dialog2) {
                ProgressDialog progressDialog = new ProgressDialog(mContext);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在下载...");
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "棒", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO
                    }
                });
                progressDialog.show();
            }
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (mPbHorizontalOldStyle.getProgress() < 10000) {
                handler.postDelayed(runnable, 500);
            } else {
                ToastUtil.showMsg(mContext, "加载完成");
            }
        }
    };

    Runnable runnable =  new Runnable() {
        @Override
        public void run() {
            mPbHorizontalOldStyle.setProgress(mPbHorizontalOldStyle.getProgress() + 5);
            handler.sendEmptyMessage(0);
        }
    };
}