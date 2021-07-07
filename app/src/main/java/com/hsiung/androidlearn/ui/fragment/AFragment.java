package com.hsiung.androidlearn.ui.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hsiung.androidlearn.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AFragment extends Fragment {

    private static final String TAG = "AFragment";
    private BFragment mBFragment;
    private IOnMessageClick mIOnMessageClick;

    private TextView mTvTitle;
    private Button mBtnChange;
    private Button mBtnReset;
    private Button mBtnMessage;

    public static AFragment newInstance(String title) {
        AFragment fragment = new AFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    public interface IOnMessageClick{
        void onClick(String msg);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mIOnMessageClick = (IOnMessageClick) context;
        } catch (ClassCastException e){
            throw new ClassCastException("Activity必须实现IOnMessageClick接口");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        Log.d(TAG, "onCreateView: ");
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTvTitle = view.findViewById(R.id.tv_title);
        if (getArguments() != null) {
            mTvTitle.setText(getArguments().getString("title"));
        }
        mBtnChange = view.findViewById(R.id.btn_change);
        mBtnReset = view.findViewById(R.id.btn_reset);
        mBtnMessage = view.findViewById(R.id.btn_message);

        OnClick onClick = new OnClick();

        mBtnChange.setOnClickListener(onClick);
        mBtnReset.setOnClickListener(onClick);
        mBtnMessage.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.btn_change) {
                if (mBFragment == null) {
                    // 实例化BFragment
                    mBFragment = new BFragment();
                }
                // 把BFragment添加到Activity中
                if ( AFragment.this.getActivity() != null) {
                    FragmentManager fragmentManager = AFragment.this.getActivity().getSupportFragmentManager();
                    Fragment fragment = fragmentManager.findFragmentByTag("a");
                    if (fragment != null) {
                        fragmentManager.beginTransaction()
                                .hide(fragment)
                                .add(R.id.fl_container, mBFragment)
                                .addToBackStack(null)
                                .commitAllowingStateLoss();
                    } else {
                        fragmentManager.beginTransaction()
                                .replace(R.id.fl_container, mBFragment)
                                .addToBackStack(null)
                                .commitAllowingStateLoss();
                    }
                }
            } else if (id == R.id.btn_reset) {
                mTvTitle.setText("我是新文字");
            } else if (id == R.id.btn_message) {
                mIOnMessageClick.onClick("你好");
            }
        }
    }
}