package com.example.newsfeed;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
public class WebViewActivity extends AppCompatActivity {
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_webview);
 WebView webView = findViewById(R.id.webView);
 ProgressBar progressBar = findViewById(R.id.webViewLoader);
 String url = getIntent().getStringExtra("url");
 webView.getSettings().setJavaScriptEnabled(true);
 webView.setWebViewClient(new WebViewClient() {
 @Override
 public void onPageFinished(WebView view, String url) {
 super.onPageFinished(view, url);
 progressBar.setVisibility(View.GONE);
 }
 });
 if (url != null) {
 webView.loadUrl(url);
 }
 }
}
