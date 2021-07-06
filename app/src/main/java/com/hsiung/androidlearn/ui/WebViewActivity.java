package com.hsiung.androidlearn.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.hsiung.androidlearn.R;

public class WebViewActivity extends AppCompatActivity {

    private static final String TAG = "WebViewActivity";
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

       mWebView = findViewById(R.id.wv);
//        // 加载本地URL
//        mWebView.loadUrl("file:///android_asset/Hello.html");

        //加载网络URL
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.setWebChromeClient(new MyWebChromeClient());

        // 在java中直接调用js代码
//        mWebView.evaluateJavascript();
//        mWebView.loadUrl();

        // js 跟java通信
//        mWebView.addJavascriptInterface();

        mWebView.loadUrl("https://m.baidu.com");
    }

    class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d(TAG, "onPageStarted...");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d(TAG, "onPageFinished...");
//            mWebView.loadUrl("Javascript:alert('hello')");
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                mWebView.evaluateJavascript("Javascript:alert('hello')", null);
//            }
        }
    }

    class MyWebChromeClient extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}