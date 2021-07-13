package com.hsiung.androidlearn.ui.actionbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.hsiung.androidlearn.R;
import com.hsiung.androidlearn.util.ToastUtil;

public class ToolBarActivity extends AppCompatActivity {

    private final Context mContext = this;

    private Toolbar mToolbar;
    private Button mBtnHide;
    private Button mBtnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);

        mBtnHide = findViewById(R.id.btn_hide_toolbar);
        mBtnShow = findViewById(R.id.btn_show_toolbar);

        setListener();

        //获取toolbar
        mToolbar = findViewById(R.id.toolbar);
        //主标题，必须在setSupportActionBar之前设置，否则无效，如果放在其他位置，则直接setTitle即可
        mToolbar.setTitle("ToolBar Title");


        //副标题+颜色
        mToolbar.setSubtitle("Sub Title");

        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        mToolbar.setNavigationContentDescription(R.string.navigationContentDescription);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //设置logo
        mToolbar.setLogo(android.R.mipmap.sym_def_app_icon);

        // 添加菜单
        mToolbar.inflateMenu(R.menu.menu);

        // 设置ToolBar菜单栏的监听事件
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                ToastUtil.showMsg(mContext, "Add selected");
//                if (id == R.id.action_refresh) {
//                    ToastUtil.showMsg(mContext, "Refresh selected");
//                }
//                else if (id == R.id.action_add) {
//                    ToastUtil.showMsg(mContext, "Add selected");
//                } else if (id == R.id.action_settings) {
//                    ToastUtil.showMsg(mContext, "Settings selected");
//                }
                return true;
            }
        });
    }


    private void setListener() {
        OnClick onClick = new OnClick();
        mBtnHide.setOnClickListener(onClick);
        mBtnShow.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.btn_hide_toolbar) {
                if (mToolbar != null) {
                    mToolbar.setVisibility(View.GONE);
                }
            } else if (id == R.id.btn_show_toolbar) {
                if (mToolbar != null) {
                    mToolbar.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}