package com.hsiung.androidlearn.ui.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hsiung.androidlearn.R;

/**
 * Author by hsiungchao, Email hsiungchao@163.com, Date on 2021/7/5.
 * PS: Not easy to write code, please indicate.
 */
public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context mContext;
    private OnItemClickListener mListener;

    public LinearAdapter(Context context, OnItemClickListener listener) {
        mContext = context;
        mListener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new LinearViewHolder1(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item_first, parent, false));
        } else
            return new LinearViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item_second, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 0) {
            ((LinearViewHolder1) holder).textView.setText("HelloWorld!");
        } else {
            ((LinearViewHolder2) holder).textView.setText("我在学习Android！");
        }
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

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 0;
        } else
            return 1;
    }

    class LinearViewHolder1 extends RecyclerView.ViewHolder {

        public TextView textView;

        public LinearViewHolder1(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_linear_title);
        }
    }

    class LinearViewHolder2 extends RecyclerView.ViewHolder {

        public TextView textView;
        public ImageView imageView;

        public LinearViewHolder2(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_linear_title);
            imageView = itemView.findViewById(R.id.iv_linear);
        }
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}
