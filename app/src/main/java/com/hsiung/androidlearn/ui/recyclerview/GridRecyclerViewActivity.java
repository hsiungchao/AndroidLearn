package com.hsiung.androidlearn.ui.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hsiung.androidlearn.R;
import com.hsiung.androidlearn.util.ToastUtil;

public class GridRecyclerViewActivity extends AppCompatActivity {
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        RecyclerView rvGrid = findViewById(R.id.rv_grid);
        rvGrid.setLayoutManager(new GridLayoutManager(mContext, 3));
        rvGrid.addItemDecoration(new MyDecoration());
        rvGrid.setAdapter(new GridAdapter(mContext, new GridAdapter.OnItemClickListener() {
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
            int width = getResources().getDimensionPixelOffset(R.dimen.dividingLineHeight);
            outRect.set(0,0, width, width);
        }
    }
}