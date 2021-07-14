package com.hsiung.androidlearn.ui.tablayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hsiung.androidlearn.R;

public class TabLayoutActivity extends AppCompatActivity {

    private Context mContext = this;

    private Button mBtnVp2;
    private Button mBtnVp2WithFragment;
    private Button mBtnVp2WithTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        mBtnVp2 = findViewById(R.id.btn_view_pager2);
        mBtnVp2WithFragment = findViewById(R.id.btn_viewpager2_fragment);
        mBtnVp2WithTabLayout = findViewById(R.id.btn_viewpager2_tablayout);

        setListener();

    }

    private void setListener() {
        OnClick onClick = new OnClick();
        mBtnVp2.setOnClickListener(onClick);
        mBtnVp2WithFragment.setOnClickListener(onClick);
        mBtnVp2WithTabLayout.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            int id = v.getId();
            if (id == R.id.btn_view_pager2) {
                intent = new Intent(mContext, ViewPager2Activity.class);
            } else if (id == R.id.btn_viewpager2_fragment) {
                intent = new Intent(mContext, ViewPager2WithFragmentActivity.class);
            } else if (id == R.id.btn_viewpager2_tablayout) {
                intent = new Intent(mContext, ViewPager2WithTabLayoutActivity.class);
            }
            startActivity(intent);
        }
    }
}