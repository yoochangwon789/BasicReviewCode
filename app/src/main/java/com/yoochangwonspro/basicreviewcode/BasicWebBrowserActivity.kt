package com.yoochangwonspro.basicreviewcode

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.inputmethod.EditorInfo
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton
import androidx.core.widget.ContentLoadingProgressBar
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class BasicWebBrowserActivity : AppCompatActivity() {

    private val addressEditText: EditText by lazy {
        findViewById(R.id.web_address_edit_text)
    }

    private val homeButton: ImageButton by lazy {
        findViewById(R.id.web_home_btn)
    }

    private val backButton: ImageButton by lazy {
        findViewById(R.id.web_back_button)
    }

    private val forwardButton: ImageButton by lazy {
        findViewById(R.id.web_forward_button)
    }

    private val webView: WebView by lazy {
        findViewById(R.id.web_view)
    }

    private val swipeRefreshLayout: SwipeRefreshLayout by lazy {
        findViewById(R.id.web_swipe_refresh_layout)
    }
    private val webProgressBar: ContentLoadingProgressBar by lazy {
        findViewById(R.id.web_progress_bar)
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_web_browser)

        initViews()
        bindViews()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initViews() {
        webView.apply {
            webViewClient = WebViewClient()
            webChromeClient = WebChromeClient()
            settings.javaScriptEnabled = true
            loadUrl(MAIN_LOAD_URL)
        }
    }

    private fun bindViews() {
        addressEditText.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                webView.loadUrl(v.text.toString())
            }
            return@setOnEditorActionListener false
        }

        homeButton.setOnClickListener {
            webView.loadUrl(MAIN_LOAD_URL)
        }

        backButton.setOnClickListener {
            webView.goBack()
        }

        forwardButton.setOnClickListener {
            webView.goForward()
        }

        swipeRefreshLayout.setOnRefreshListener {
            webView.reload()
        }
    }

    inner class WebChromeClient: android.webkit.WebChromeClient() {

        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)
            webProgressBar.progress = newProgress
        }
    }

    inner class WebViewClient: android.webkit.WebViewClient() {

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            webProgressBar.show()
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)

            swipeRefreshLayout.isRefreshing = false
            webProgressBar.hide()
        }
    }

    companion object {
        private const val MAIN_LOAD_URL = "http://www.google.com"
    }
}