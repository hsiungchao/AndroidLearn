package com.hsiung.androidlearn.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hsiung.androidlearn.R;
import com.hsiung.androidlearn.util.ToastUtil;
import com.hsiung.androidlearn.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {

    private final Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);

        Button btnCustomDialog = findViewById(R.id.btn_custom_dialog);
        btnCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(mContext, R.style.CustomDialog);
                customDialog.setTitle("提示")
                        .setMessage("确认删除此项？")
                        .setCancel("取消", new CustomDialog.IOnCancelListener() {
                            @Override
                            public void onCancel(CustomDialog dialog) {
                                ToastUtil.showMsg(mContext, "Cancel...");
                            }
                        })
                        .setConfirm("确认", new CustomDialog.IOnConfirmListener() {
                            @Override
                            public void onConfirm(CustomDialog dialog) {
                                ToastUtil.showMsg(mContext, "Confirm...");
                            }
                        }).show();
            }
        });

    }
}