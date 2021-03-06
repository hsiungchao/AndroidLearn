package com.hsiung.androidlearn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hsiung.androidlearn.event.EventFragment;
import com.hsiung.androidlearn.thirdpartylab.ThirdPartyLibFragment;
import com.hsiung.androidlearn.ui.UIFragment;

public class HomeActivity extends AppCompatActivity {

    private final Context mContext = this;
    private UIFragment mUIFragment;
    private EventFragment mEventFragment;
    private ThirdPartyLibFragment mLibFragment;

    private Toolbar mToolbar;
    private TextView mTvToolBarTitle;
    private BottomNavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // 初始化Fragment
        mUIFragment = UIFragment.newInstance(null, null);
        mEventFragment = EventFragment.newInstance(null, null);
        mLibFragment = ThirdPartyLibFragment.newInstance(null, null);

        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, mUIFragment).commitAllowingStateLoss();

        // 隐藏默认的ActionBar
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.hide();
//        }

        // ToolBar的设置
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        // 设置NavigationIcon的点击事件
//        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });


        mTvToolBarTitle = findViewById(R.id.tv_toolbar_title);
        mTvToolBarTitle.setText(R.string.ui);


        // BottomNavigationView设置
        mNavigationView = findViewById(R.id.nav_bottom_navigation);
        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_ui) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, mUIFragment).commitAllowingStateLoss();
                    mTvToolBarTitle.setText(R.string.ui);
                } else if (id == R.id.nav_event) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, mEventFragment).commitAllowingStateLoss();
                    mTvToolBarTitle.setText(R.string.event);
                } else if (id == R.id.nav_third_party_lab) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, mLibFragment).commitAllowingStateLoss();
                    mTvToolBarTitle.setText(R.string.third_party_lab);
                }
                return true;
            }
        });
    }
}