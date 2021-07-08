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

        //隐藏默认actionbar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        //获取toolbar
        mToolbar = findViewById(R.id.toolbar);
        //主标题，必须在setSupportActionBar之前设置，否则无效，如果放在其他位置，则直接setTitle即可
        mToolbar.setTitle("ToolBar Title");
        //用toolbar替换actionbar
        setSupportActionBar(mToolbar);

        //副标题+颜色
        mToolbar.setSubtitle("Sub Title");

        //左侧按钮：可见+更换图标+点击监听
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//显示toolbar的返回按钮
//        toolBar.setNavigationIcon(R.mipmap.back_white);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //设置logo
//        mToolbar.setLogo(android.R.mipmap.sym_def_app_icon);

    }

    /**
     * 复写：添加菜单布局
     * */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * 复写：设置菜单监听
     * */
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                ToastUtil.showMsg(mContext, "Refresh selected");
                break;
            case R.id.action_add:
                ToastUtil.showMsg(mContext, "Add selected");
                break;
            case R.id.action_settings:
                ToastUtil.showMsg(mContext, "Settings selected");
                break;
            default:
                break;
        }
        return true;
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