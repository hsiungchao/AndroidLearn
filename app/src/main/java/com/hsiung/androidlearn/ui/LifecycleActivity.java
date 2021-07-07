package com.hsiung.androidlearn.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.hsiung.androidlearn.R;

public class LifecycleActivity extends AppCompatActivity {

    private static final String TAG = "LifecycleActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

//        Logger.d("---onCreate---");
        Log.d(TAG, "---onCreate---");
    }

    @Override
    protected void onStart() {
        super.onStart();
//        Logger.d("---onStart---");
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
//        Logger.d("---onResume---");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
//        Logger.d("---onPause---");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
//        Logger.d("---onStop---");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
//        Logger.d("---onRestart---");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
//        Logger.d("---onDestroy---");
    }
}