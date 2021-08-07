package com.yoochangwonspro.basicreviewcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
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
    }
}