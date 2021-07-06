package com.hsiung.androidlearn.ui.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hsiung.androidlearn.R;

/**
 * Author by hsiungchao, Email hsiungchao@163.com, Date on 2021/7/6.
 * PS: Not easy to write code, please indicate.
 */
public class WaterfallsFlowAdapter extends RecyclerView.Adapter<WaterfallsFlowAdapter.WaterfallsFlowViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public WaterfallsFlowAdapter(Context context, OnItemClickListener listener) {
        mContext = context;
        mListener = listener;
    }

    @NonNull
    @Override
    public WaterfallsFlowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WaterfallsFlowViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_waterfalls_flow_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WaterfallsFlowViewHolder holder, int position) {
        if (position % 2 != 0) {
            holder.mImageView.setImageResource(R.drawable.img1);
//            Glide.with(mContext).load(R.drawable.img1).into(holder.mImageView);
        } else {
            holder.mImageView.setImageResource(R.drawable.image2);
//            Glide.with(mContext).load(R.drawable.image2).into(holder.mImageView);
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

    class WaterfallsFlowViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        public WaterfallsFlowViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iv_waterfalls_flow);
        }
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}
