package com.hsiung.androidlearn.ui.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hsiung.androidlearn.R;

public class RecyclerViewActivity extends AppCompatActivity {

    private final Context mContext = this;

    private Button mBtnLinear;
    private Button mBtnHorizontal;
    private Button mBtnGrid;
    private Button mBtnWaterfallsFlow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mBtnLinear = findViewById(R.id.btn_linear);
        mBtnHorizontal = findViewById(R.id.btn_horizontal);
        mBtnGrid = findViewById(R.id.btn_grid);
        mBtnWaterfallsFlow = findViewById(R.id.btn_waterfalls_flow);

        setListener();
    }

    private void setListener() {
        OnClick onClick = new OnClick();
        mBtnLinear.setOnClickListener(onClick);
        mBtnHorizontal.setOnClickListener(onClick);
        mBtnGrid.setOnClickListener(onClick);
        mBtnWaterfallsFlow.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            int id  = v.getId();
            if (id == R.id.btn_linear) {
                // 跳转到列表视图演示界面
                intent = new Intent(mContext, LinearRecyclerViewActivity.class);
            } else if (id == R.id.btn_horizontal) {
                // 跳转到水平滚动视图演示界面

            } else if (id == R.id.btn_grid) {
                // 跳转到网格视图演示界面

            } else if (id == R.id.btn_waterfalls_flow) {
                // 跳转到瀑布流视图演示界面
            }
            startActivity(intent);
        }
    }
}