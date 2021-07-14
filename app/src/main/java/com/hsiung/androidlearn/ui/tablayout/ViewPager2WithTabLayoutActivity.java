package com.hsiung.androidlearn.ui.tablayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.hsiung.androidlearn.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPager2WithTabLayoutActivity extends AppCompatActivity {

    private Context mContext = this;
    private List<Fragment> mFragments;

    private TabLayout mTabLayout;
    private ViewPager2 mViewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2_with_tab_layout);

        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager2 = findViewById(R.id.vp2);

        ArrayList<String> titleList = new ArrayList<>();
        titleList.add("One");
        titleList.add("Two");
        titleList.add("Three");
        titleList.add("Four");

        mFragments = new ArrayList<>();
        mFragments.add(BlankFragment.newInstance("汉中"));
        mFragments.add(BlankFragment.newInstance("常州"));
        mFragments.add(BlankFragment.newInstance("苏州"));
        mFragments.add(BlankFragment.newInstance("西安"));

        // 给ViewPager设置适配器
        mViewPager2.setAdapter(new MyAdapter((FragmentActivity) mContext, mFragments));

        // 设置TabLayout
//        new TabLayoutMediator(mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
//            @Override
//            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
//                tab.setText(titleList.get(position));
//            }
//        }).attach();
        new TabLayoutMediator(mTabLayout, mViewPager2, (tab, position) -> tab.setText(titleList.get(position))).attach();


    }
}