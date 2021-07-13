package com.hsiung.androidlearn.ui.tablayput;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hsiung.androidlearn.R;

/**
 * Author by hsiungchao, Email hsiungchao@163.com, Date on 2021/7/13.
 * PS: Not easy to write code, please indicate.
 */
public class ViewPager2Adapter extends RecyclerView.Adapter<ViewPager2Adapter.CardViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public ViewPager2Adapter(Context context, OnItemClickListener listener) {
        mContext = context;
        mListener = listener;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CardViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_view_pager2_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {

        switch (position) {
            case 0:
                holder.tvDescribe.setText("first");
                break;
            case 1:
                holder.tvDescribe.setText("second");
                holder.itemView.setBackgroundResource(R.color.red);
                break;
            case 2:
                holder.tvDescribe.setText("Third");
                holder.itemView.setBackgroundResource(R.color.yellow);
                break;
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
        return 3;
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder{
        public TextView tvDescribe;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDescribe = itemView.findViewById(R.id.tv_description);
        }
    }

    public interface OnItemClickListener{
        void onClick(int position);
    }
}
