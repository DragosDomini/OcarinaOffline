package com.cyndyr.ocarina

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.graphics.Color
import android.view.Gravity

class MainActivity : Activity() {
    private lateinit var webView: WebView
    private lateinit var errorPanel: LinearLayout

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.rgb(23, 20, 33))
        }
        webView = WebView(this).apply {
            setBackgroundColor(Color.rgb(23, 20, 33))
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            settings.mediaPlaybackRequiresUserGesture = false
            settings.loadsImagesAutomatically = true
            settings.javaScriptCanOpenWindowsAutomatically = true
            webChromeClient = WebChromeClient()
            webViewClient = object : WebViewClient() {
                override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
                    if (request.isForMainFrame) errorPanel.visibility = View.VISIBLE
                }
                override fun onPageFinished(view: WebView, url: String) {
                    errorPanel.visibility = View.GONE
                }
            }
        }
        errorPanel = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(32, 32, 32, 32)
            setBackgroundColor(Color.rgb(23, 20, 33))
            visibility = View.GONE
            addView(TextView(this@MainActivity).apply {
                text = "Couldn't load Ocarina Player. Check your internet connection and try again."
                setTextColor(Color.WHITE)
                textSize = 16f
                gravity = Gravity.CENTER
            })
            addView(Button(this@MainActivity).apply {
                text = "Try again"
                setOnClickListener { visibility = View.GONE; webView.reload() }
            })
        }
        root.addView(webView, LinearLayout.LayoutParams(-1, 0, 1f))
        root.addView(errorPanel, LinearLayout.LayoutParams(-1, -1))
        setContentView(root)

        if (savedInstanceState != null) webView.restoreState(savedInstanceState)
        else webView.loadUrl("https://ocarina.toomuchofheaven.com/")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        webView.saveState(outState)
        super.onSaveInstanceState(outState)
    }

    @Deprecated("Deprecated in Android API, retained for broad device compatibility")
    override fun onBackPressed() {
        if (::webView.isInitialized && webView.canGoBack()) webView.goBack()
        else super.onBackPressed()
    }

    override fun onDestroy() {
        if (::webView.isInitialized) webView.destroy()
        super.onDestroy()
    }
}
