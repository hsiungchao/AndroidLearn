package com.hsiung.androidlearn.ui.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hsiung.androidlearn.R;

/**
 * Author by hsiungchao, Email hsiungchao@163.com, Date on 2021/7/6.
 * PS: Not easy to write code, please indicate.
 */
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public GridAdapter(Context context, OnItemClickListener listener) {
        mContext = context;
        mListener = listener;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GridViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_grid_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        // 赋值
        holder.mTextView.setText("花");
        Glide.with(mContext).load("https://img1.baidu.com/it/u=2870390419,1539547333&fm=26&fmt=auto&gp=0.jpg").into(holder.mImageView);
        // 设置监听事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class GridViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImageView;
        private TextView mTextView;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iv_grid);
            mTextView = itemView.findViewById(R.id.tv_grid_title);
        }
    }


    public interface OnItemClickListener {
        void onClick(int position);
    }
}
