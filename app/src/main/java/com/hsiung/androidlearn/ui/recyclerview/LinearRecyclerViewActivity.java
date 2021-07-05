package com.hsiung.androidlearn.ui.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

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
        recyclerView.setAdapter(new LinearAdapter(mContext, new LinearAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                ToastUtil.showMsg(mContext, "click..." + position);
            }
        }));

    }
}