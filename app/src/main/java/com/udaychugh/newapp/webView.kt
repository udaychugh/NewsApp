package com.udaychugh.newapp

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class webView : AppCompatActivity() {
    var toolbar: Toolbar? = null
    var webview: WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        toolbar = findViewById(R.id.toolbar)
        webview = findViewById(R.id.webview)
        setSupportActionBar(toolbar)
        val intent = intent
        val url = intent.getStringExtra("url")
        webview.setWebViewClient(WebViewClient())
        webview.loadUrl(url!!)
    }
}