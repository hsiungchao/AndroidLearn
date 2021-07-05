package com.hsiung.androidlearn.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Author by hsiungchao, Email hsiungchao@163.com, Date on 2021/7/5.
 * PS: Not easy to write code, please indicate.
 */
public class ToastUtil {
    private static Toast sToast;
    public static void showMsg(Context context, String msg) {
        if (sToast == null) {
            sToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            sToast.setText(msg);
        }
        sToast.show();
    }
}
