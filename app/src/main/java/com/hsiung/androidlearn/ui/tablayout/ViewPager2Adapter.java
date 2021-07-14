package com.hsiung.androidlearn.ui.tablayout;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hsiung.androidlearn.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by hsiungchao, Email hsiungchao@163.com, Date on 2021/7/13.
 * PS: Not easy to write code, please indicate.
 */
public class ViewPager2Adapter extends RecyclerView.Adapter<ViewPager2Adapter.CardViewHolder> {

    private List<String> mItems = new ArrayList<>();
    private List<Integer> mColors = new ArrayList<>();

    private Context mContext;
    private OnItemClickListener mListener;

    public ViewPager2Adapter(Context context, OnItemClickListener listener) {
        mContext = context;
        mListener = listener;

        for (int i = 0; i < 10; i++) {
            mItems.add("我是第"+(i+1)+"个");
        }
        mColors.add(android.R.color.white);
        mColors.add(R.color.grayDark);
        mColors.add(R.color.yellow);
        mColors.add(R.color.purple_200);
        mColors.add(R.color.green);
        mColors.add(R.color.purple_500);
        mColors.add(R.color.teal_700);
        mColors.add(R.color.skyBlue);
        mColors.add(R.color.red);
        mColors.add(R.color.teal_200);
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CardViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_view_pager2_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {

        holder.llContainer.setBackgroundResource(mColors.get(position));
        holder.tvDescribe.setText(mItems.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder{
        public LinearLayout llContainer;
        public TextView tvDescribe;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            llContainer = itemView.findViewById(R.id.ll_container);
            tvDescribe = itemView.findViewById(R.id.tv_description);
        }
    }

    public interface OnItemClickListener{
        void onClick(int position);
    }
}
