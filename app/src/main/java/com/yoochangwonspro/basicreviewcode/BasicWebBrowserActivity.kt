package com.yoochangwonspro.basicreviewcode

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.inputmethod.EditorInfo
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class BasicWebBrowserActivity : AppCompatActivity() {

    private val addressEditText: EditText by lazy {
        findViewById(R.id.web_address_edit_text)
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
    }

    companion object {
        private const val MAIN_LOAD_URL = "http://www.google.com"
    }
}