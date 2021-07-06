package com.hsiung.androidlearn.ui.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hsiung.androidlearn.R;

public class WaterfallsFlowRecyclerViewActivity extends AppCompatActivity {

    private final Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterfalls_flow_recycler_view);

        RecyclerView rvWaterfallsFlow = findViewById(R.id.rv_waterfalls_flow);
        rvWaterfallsFlow.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rvWaterfallsFlow.addItemDecoration(new MyDecoration());
        rvWaterfallsFlow.setAdapter(new WaterfallsFlowAdapter(mContext, new WaterfallsFlowAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(mContext, "click..." + position, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    private class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap = getResources().getDimensionPixelOffset(R.dimen.dividingLineHeight1);
            outRect.set(gap, gap, gap, gap);
        }
    }
}