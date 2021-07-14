package com.hsiung.androidlearn.ui.tablayout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hsiung.androidlearn.R;

public class BlankFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mTextString = "xxx";

    private View mRootView;

    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance(String param1) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTextString = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.fragment_blank, container, false);
        }
        initView();
        return mRootView;
    }

    private void initView() {
        TextView textView = mRootView.findViewById(R.id.tv_blank_fragment);
        textView.setText(mTextString);

    }
}