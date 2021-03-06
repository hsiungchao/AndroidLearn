package com.hsiung.androidlearn.ui.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import com.hsiung.androidlearn.R;
import com.hsiung.androidlearn.util.ToastUtil;

public class LinearRecyclerViewActivity extends AppCompatActivity {

    private final Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);

        RecyclerView recyclerView = findViewById(R.id.rv_linear);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.addItemDecoration(new MyDecoration());
        recyclerView.setAdapter(new LinearAdapter(mContext, new LinearAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                ToastUtil.showMsg(mContext, "click..." + position);
            }
        }));

    }

    private class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividingLineHeight));
        }
    }
}