package com.hsiung.androidlearn.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hsiung.androidlearn.R;
import com.hsiung.androidlearn.ui.gridview.GridViewActivity;
import com.hsiung.androidlearn.ui.listview.ListViewActivity;
import com.hsiung.androidlearn.ui.recyclerview.RecyclerViewActivity;

public class UIFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private Context mContext;

    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEditText;
    private Button mBtnRadioButton;
    private Button mBtnCheckBox;
    private Button mBtnImageView;
    private Button mBtnListView;
    private Button mBtnGridView;
    private Button mBtnRecyclerView;
    private Button mBtnWebView;

    public UIFragment() {
    }

    public static UIFragment newInstance(String param1, String param2) {
        UIFragment fragment = new UIFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ui, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBtnTextView = view.findViewById(R.id.btn_text_View);
        mBtnButton = view.findViewById(R.id.btn_button);
        mBtnEditText = view.findViewById(R.id.btn_edit_text);
        mBtnRadioButton = view.findViewById(R.id.btn_radio_button);
        mBtnCheckBox = view.findViewById(R.id.btn_check_box);
        mBtnImageView = view.findViewById(R.id.btn_image_view);
        mBtnListView = view.findViewById(R.id.btn_list_view);
        mBtnGridView = view.findViewById(R.id.btn_grid_view);
        mBtnRecyclerView = view.findViewById(R.id.btn_recycler_view);
        mBtnWebView = view.findViewById(R.id.btn_web_view);

        setListener();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void setListener() {
        OnClick onClick = new OnClick();
        mBtnTextView.setOnClickListener(onClick);
        mBtnButton.setOnClickListener(onClick);
        mBtnEditText.setOnClickListener(onClick);
        mBtnRadioButton.setOnClickListener(onClick);
        mBtnCheckBox.setOnClickListener(onClick);
        mBtnImageView.setOnClickListener(onClick);
        mBtnListView.setOnClickListener(onClick);
        mBtnGridView.setOnClickListener(onClick);
        mBtnRecyclerView.setOnClickListener(onClick);
        mBtnWebView.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int id = v.getId();
            Intent intent = null;
            if (id == R.id.btn_text_View) {
                // 跳转到TextView演示界面
                intent = new Intent(mContext, TextViewActivity.class);
            } else  if (id == R.id.btn_button) {
                // 跳转到Button演示界面
                intent = new Intent(mContext, ButtonActivity.class);
            } else if (id == R.id.btn_edit_text){
                // 跳转到EditText演示界面
                intent = new Intent(mContext, EditTextActivity.class);
            } else if (id == R.id.btn_radio_button) {
                // 跳转到RadioButton演示界面
                intent = new Intent(mContext, RadioButtonActivity.class);
            } else  if (id == R.id.btn_check_box) {
                // 跳转到CheckBox演示界面
                intent = new Intent(mContext, CheckBoxActivity.class);
            } else if (id == R.id.btn_image_view) {
                // 跳转到ImageView演示界面
                intent = new Intent(mContext, ImageViewActivity.class);
            } else if (id == R.id.btn_list_view) {
                // 跳转到ListView演示界面
                intent = new Intent(mContext, ListViewActivity.class);
            } else if (id == R.id.btn_grid_view) {
                // 跳转到GridView演示界面
                intent = new Intent(mContext, GridViewActivity.class);
            } else if (id == R.id.btn_recycler_view) {
                // 跳转到RecyclerView演示界面
                intent = new Intent(mContext, RecyclerViewActivity.class);
            } else  if (id == R.id.btn_web_view) {
                // 跳转到WebView演示界面
                intent = new Intent(mContext, WebViewActivity.class);
            }
            startActivity(intent);
        }
    }

}