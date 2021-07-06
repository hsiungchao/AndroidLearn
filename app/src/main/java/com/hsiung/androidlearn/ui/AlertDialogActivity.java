package com.hsiung.androidlearn.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hsiung.androidlearn.R;
import com.hsiung.androidlearn.util.ToastUtil;

public class AlertDialogActivity extends AppCompatActivity {

    private final Context mContext = this;

    private Button mBtnDefault;
    private Button mBtnSingleSelection1;
    private Button mBtnSingleSelection2;
    private Button mBtnMultiSelection;
    private Button mBtnCustomize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        mBtnDefault = findViewById(R.id.btn_default_dialog);
        mBtnSingleSelection1 = findViewById(R.id.btn_single_selection_dialog1);
        mBtnSingleSelection2 = findViewById(R.id.btn_single_selection_dialog2);
        mBtnMultiSelection = findViewById(R.id.btn_multi_selection_dialog);
        mBtnCustomize = findViewById(R.id.btn_customize_dialog);

        setListener();
    }

    private void setListener() {
        OnClick onClick = new OnClick();
        mBtnDefault.setOnClickListener(onClick);
        mBtnSingleSelection1.setOnClickListener(onClick);
        mBtnSingleSelection2.setOnClickListener(onClick);
        mBtnMultiSelection.setOnClickListener(onClick);
        mBtnCustomize.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.btn_default_dialog) {
                // 默认样式Dialog
                AlertDialog.Builder defaultBuilder = new AlertDialog.Builder(mContext);
                defaultBuilder.setTitle("请回答")
                        .setMessage("你觉得课程如何？")
                        .setIcon(R.drawable.icon_username)
                        .setPositiveButton("棒", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ToastUtil.showMsg(mContext, "你很诚实！");
                            }
                        })
                        .setNeutralButton("还行", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ToastUtil.showMsg(mContext, "你在瞅瞅！");
                            }
                        })
                        .setNegativeButton("不好", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ToastUtil.showMsg(mContext, "睁眼说瞎话");
                            }
                        })
                        .show();

            } else if (id == R.id.btn_single_selection_dialog1) {
                // 单选Dialog样式
                final String[] array = new String[]{"男", "女"};
                AlertDialog.Builder singleBuilder = new AlertDialog.Builder(mContext);
                singleBuilder.setTitle("选择性别")
                        .setItems(array, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ToastUtil.showMsg(mContext, array[which]);
                            }
                        })
                        .show();

            } else if (id == R.id.btn_single_selection_dialog2) {
                // 单选Dialog样式
                final String[] array = new String[]{"男", "女"};
                AlertDialog.Builder singleBuilder = new AlertDialog.Builder(mContext);
                singleBuilder.setTitle("选择性别")
                        .setSingleChoiceItems(array, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ToastUtil.showMsg(mContext, array[which]);
                                dialog.dismiss();
                            }
                        })
                        .show();

            } else if (id == R.id.btn_multi_selection_dialog) {
                // 多选Dialog样式
                final String[] array = new String[]{"唱歌", "跳舞", "写代码"};
                boolean[] isSelected = new boolean[]{false, false, true};
                AlertDialog.Builder multiBuilder = new AlertDialog.Builder(mContext);
                multiBuilder.setTitle("选择兴趣")
                        .setMultiChoiceItems(array, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                ToastUtil.showMsg(mContext, array[which] + " : " + isChecked);
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO
                            }
                        })
                        .setNeutralButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO
                            }
                        })
                        .show();

            } else if (id == R.id.btn_customize_dialog) {
                // 自定义Dialog样式
                AlertDialog.Builder customizeBuilder = new AlertDialog.Builder(mContext);
                View view = LayoutInflater.from(mContext).inflate(R.layout.layout_dialog, null);
                EditText etUserName = view.findViewById(R.id.et_username);
                EditText etPassWord = view.findViewById(R.id.et_password);
                Button btnLogin = view.findViewById(R.id.btn_login);
                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                customizeBuilder.setTitle("请先登录").setView(view).show();
            }
        }
    }
}