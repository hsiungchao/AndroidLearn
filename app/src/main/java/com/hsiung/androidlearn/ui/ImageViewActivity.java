package com.hsiung.androidlearn.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hsiung.androidlearn.R;

public class ImageViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        ImageView iv4 = findViewById(R.id.iv_4);
        Glide.with(this).load("https://img1.baidu.com/it/u=2496571732,442429806&fm=26&fmt=auto&gp=0.jpg").into(iv4);
    }
}