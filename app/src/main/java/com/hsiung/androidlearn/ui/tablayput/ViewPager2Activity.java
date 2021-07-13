package com.hsiung.androidlearn.ui.tablayput;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.hsiung.androidlearn.R;

public class ViewPager2Activity extends AppCompatActivity {

    private Context mContext = this;

    private ViewPager2 mVp2TabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2);

        mVp2TabLayout = findViewById(R.id.vp2_tab_layout);

        mVp2TabLayout.setAdapter(new ViewPager2Adapter(mContext, new ViewPager2Adapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(mContext, "click..." + position, Toast.LENGTH_SHORT).show();
            }
        }));

    }
}