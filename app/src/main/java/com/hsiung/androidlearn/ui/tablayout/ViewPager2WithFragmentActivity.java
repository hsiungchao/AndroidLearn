package com.hsiung.androidlearn.ui.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.hsiung.androidlearn.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPager2WithFragmentActivity extends AppCompatActivity {

    private ViewPager2 mViewPager2;

    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2_with_fragment);

        mViewPager2 = findViewById(R.id.vp2_view_pager2);
        mFragments = new ArrayList<>();
        mFragments.add(BlankFragment.newInstance("汉中"));
        mFragments.add(BlankFragment.newInstance("常州"));
        mFragments.add(BlankFragment.newInstance("苏州"));
        mFragments.add(BlankFragment.newInstance("西安"));
        mViewPager2.setAdapter(new MyAdapter(this, mFragments));

    }
}