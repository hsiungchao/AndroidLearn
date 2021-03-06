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
import com.hsiung.androidlearn.ui.actionbar.ToolBarActivity;
import com.hsiung.androidlearn.ui.fragment.ContainerActivity;
import com.hsiung.androidlearn.ui.gridview.GridViewActivity;
import com.hsiung.androidlearn.ui.jump.Test1Activity;
import com.hsiung.androidlearn.ui.listview.ListViewActivity;
import com.hsiung.androidlearn.ui.recyclerview.RecyclerViewActivity;
import com.hsiung.androidlearn.ui.statusbar.StatusBarActivity;
import com.hsiung.androidlearn.ui.tablayout.TabLayoutActivity;

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
    private Button mBtnToast;
    private Button mBtnDialog;
    private Button mBtnProgress;
    private Button mBtnCustomDialog;
    private Button mBtnPopupWindow;
    private Button mBtnLifecycle;
    private Button mBtnActivityJump;
    private Button mBtnFragment;
    private Button mBtnToolBar;
    private Button mBtnStatusBar;
    private Button mBtnTabLayout;

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
        mBtnToast = view.findViewById(R.id.btn_toast);
        mBtnDialog = view.findViewById(R.id.btn_dialog);
        mBtnProgress = view.findViewById(R.id.btn_progress);
        mBtnCustomDialog = view.findViewById(R.id.btn_custom_dialog);
        mBtnPopupWindow = view.findViewById(R.id.btn_popup_window);
        mBtnLifecycle = view.findViewById(R.id.btn_activity_lifecycle);
        mBtnActivityJump = view.findViewById(R.id.btn_activity_jump);
        mBtnFragment = view.findViewById(R.id.btn_fragment);
        mBtnToolBar = view.findViewById(R.id.btn_tool_bar);
        mBtnStatusBar = view.findViewById(R.id.btn_status_bar);
        mBtnTabLayout = view.findViewById(R.id.btn_tab_layout);
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
        mBtnToast.setOnClickListener(onClick);
        mBtnDialog.setOnClickListener(onClick);
        mBtnProgress.setOnClickListener(onClick);
        mBtnCustomDialog.setOnClickListener(onClick);
        mBtnPopupWindow.setOnClickListener(onClick);
        mBtnLifecycle.setOnClickListener(onClick);
        mBtnActivityJump.setOnClickListener(onClick);
        mBtnFragment.setOnClickListener(onClick);
        mBtnToolBar.setOnClickListener(onClick);
        mBtnStatusBar.setOnClickListener(onClick);
        mBtnTabLayout.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            int id = v.getId();
            Intent intent = null;
            if (id == R.id.btn_text_View) {
                // ?????????TextView????????????
                intent = new Intent(mContext, TextViewActivity.class);
            } else if (id == R.id.btn_button) {
                // ?????????Button????????????
                intent = new Intent(mContext, ButtonActivity.class);
            } else if (id == R.id.btn_edit_text) {
                // ?????????EditText????????????
                intent = new Intent(mContext, EditTextActivity.class);
            } else if (id == R.id.btn_radio_button) {
                // ?????????RadioButton????????????
                intent = new Intent(mContext, RadioButtonActivity.class);
            } else if (id == R.id.btn_check_box) {
                // ?????????CheckBox????????????
                intent = new Intent(mContext, CheckBoxActivity.class);
            } else if (id == R.id.btn_image_view) {
                // ?????????ImageView????????????
                intent = new Intent(mContext, ImageViewActivity.class);
            } else if (id == R.id.btn_list_view) {
                // ?????????ListView????????????
                intent = new Intent(mContext, ListViewActivity.class);
            } else if (id == R.id.btn_grid_view) {
                // ?????????GridView????????????
                intent = new Intent(mContext, GridViewActivity.class);
            } else if (id == R.id.btn_recycler_view) {
                // ?????????RecyclerView????????????
                intent = new Intent(mContext, RecyclerViewActivity.class);
            } else if (id == R.id.btn_web_view) {
                // ?????????WebView????????????
                intent = new Intent(mContext, WebViewActivity.class);
            } else if (id == R.id.btn_toast) {
                // ?????????Toast????????????
                intent = new Intent(mContext, ToastActivity.class);
            } else if (id == R.id.btn_dialog) {
                // ?????????Dialog????????????
                intent = new Intent(mContext, AlertDialogActivity.class);
            } else if (id == R.id.btn_progress) {
                // ?????????Progress????????????
                intent = new Intent(mContext, ProgressActivity.class);
            } else if (id == R.id.btn_custom_dialog) {
                // ?????????CustomDialog????????????
                intent = new Intent(mContext, CustomDialogActivity.class);
            } else if (id == R.id.btn_popup_window) {
                // ?????????PopWindow????????????
                intent = new Intent(mContext, PopupWindowActivity.class);
            } else if (id == R.id.btn_activity_lifecycle) {
                // ?????????Lifecycle????????????
                intent = new Intent(mContext, LifecycleActivity.class);
            } else if (id == R.id.btn_activity_jump) {
                // ?????????Activity Jump????????????
                intent = new Intent(mContext, Test1Activity.class);
            } else if (id == R.id.btn_fragment) {
                // ?????????Fragment????????????
                intent = new Intent(mContext, ContainerActivity.class);
            } else if (id == R.id.btn_tool_bar) {
                // ?????????ToolBar????????????
                intent = new Intent(mContext, ToolBarActivity.class);
            } else if (id == R.id.btn_status_bar) {
                // ?????????StatusBar????????????
                intent = new Intent(mContext, StatusBarActivity.class);
            } else if (id == R.id.btn_tab_layout) {
                // ?????????TabLayout????????????
                intent = new Intent(mContext, TabLayoutActivity.class);
            }
            startActivity(intent);
        }
    }

}