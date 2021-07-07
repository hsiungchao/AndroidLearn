package com.hsiung.androidlearn.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.hsiung.androidlearn.R;

/**
 * Author by hsiungchao, Email hsiungchao@163.com, Date on 2021/7/7.
 * PS: Not easy to write code, please indicate.
 */
public class CustomDialog extends Dialog implements View.OnClickListener {
    private TextView mTvTitle, mTvMessage, mTvCancel, mTvConfirm;
    private String mTitle;
    private String mMessage;
    private String mCancel;
    private String mConfirm;

    private IOnCancelListener mCancelListener;
    private IOnConfirmListener mConfirmListener;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public CustomDialog setTitle(String title) {
        mTitle = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        mMessage = message;
        return this;
    }

    public CustomDialog setCancel(String cancel, IOnCancelListener listener) {
        mCancel = cancel;
        mCancelListener = listener;
        return this;
    }

    public CustomDialog setConfirm(String confirm, IOnConfirmListener listener) {
        mConfirm = confirm;
        mConfirmListener = listener;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);

        // 设置宽度
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        p.width = (int) (size.x * 0.8); // 设置Dialog的宽度为当前屏幕的80%
        getWindow().setAttributes(p);

        mTvTitle = findViewById(R.id.tv_title);
        mTvMessage = findViewById(R.id.tv_message);
        mTvCancel = findViewById(R.id.tv_cancel);
        mTvConfirm = findViewById(R.id.tv_confirm);
        if (!TextUtils.isEmpty(mTitle)) {
            mTvTitle.setText(mTitle);
        }
        if (!TextUtils.isEmpty(mMessage)) {
            mTvMessage.setText(mMessage);
        }
        if (!TextUtils.isEmpty(mCancel)) {
            mTvCancel.setText(mCancel);
        }
        if (!TextUtils.isEmpty(mConfirm)) {
            mTvConfirm.setText(mConfirm);
        }
        mTvCancel.setOnClickListener(this);
        mTvConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv_cancel){
            if (mCancelListener != null) {
                mCancelListener.onCancel(this);
            }
            dismiss();
        } else if (id == R.id.tv_confirm) {
            if (mConfirmListener != null)
                mConfirmListener.onConfirm(this);
            dismiss();
        }
    }

    public interface IOnCancelListener {
        void onCancel(CustomDialog dialog);
    }

    public interface IOnConfirmListener {
        void onConfirm(CustomDialog dialog);
    }
}
