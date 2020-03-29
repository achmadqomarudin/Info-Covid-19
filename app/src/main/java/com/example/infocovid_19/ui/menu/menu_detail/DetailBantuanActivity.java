package com.example.infocovid_19.ui.menu.menu_detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.infocovid_19.R;

public class DetailBantuanActivity extends AppCompatActivity {

    private WebView webView;
    private SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_bantuan);

        setView();
        initView();
    }

    private void setView() {
        webView = findViewById(R.id.webview);
        swipe   = findViewById(R.id.swipe);
    }

    private void initView() {
        final int i = getIntent().getIntExtra("position", 0);

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (i == 0) {
                    setToolbar("Konsultasi Dokter");
                    setLinkWeb("https://www.sehatq.com/cari?q=corona");
                } else if (i == 1) {
                    setToolbar("Rumah Sakit Rujukan");
                    setLinkWeb("https://www.covid19.go.id/2020/03/23/daftar-rumah-sakit-rujukan-covid-19/");
                }
            }
        });

        if (i == 0) {
            setToolbar("Konsultasi Dokter");
            setLinkWeb("https://www.sehatq.com/cari?q=corona");
        } else if (i == 1) {
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            setToolbar("Rumah Sakit Rujukan");
            setLinkWeb("https://www.covid19.go.id/2020/03/23/daftar-rumah-sakit-rujukan-covid-19/");
        }
    }

    private void setToolbar(String title) {
        Toolbar toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);

        if (toolBar != null) {
            getSupportActionBar().setTitle(title);
            toolBar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //What to do on back clicked
                    onBackPressed();
                }
            });
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setLinkWeb(String linkWeb) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setSupportZoom(true);
        webView.loadUrl(linkWeb);
        swipe.setRefreshing(true);
        webView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                webView.loadUrl("file:///android_asset/error.html");
            }

            public void onPageFinished(WebView view, String url) {
                //Hide the SwipeReefreshLayout
                swipe.setRefreshing(false);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            finish();
        }
    }
}
