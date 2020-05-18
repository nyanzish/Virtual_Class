package com.example.virtualclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mWebView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mWebView = findViewById<View>(R.id.webview) as WebView
        mWebView!!.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                url: String?
            ): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        val webSettings = mWebView!!.settings
        webSettings.javaScriptEnabled =true
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH)
        WebSettings.LOAD_CACHE_ELSE_NETWORK
        webSettings.setAppCacheEnabled(true)
        webSettings.domStorageEnabled = true
        webSettings.javaScriptCanOpenWindowsAutomatically
        webSettings.setSupportMultipleWindows(true)
        //webSettings.supportMultipleWindows()
        //webview.onFocusChangeListener
        //webSettings.cacheMode

        webSettings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS
        webSettings.useWideViewPort = true
        webSettings.savePassword = true
        webSettings.saveFormData = true
        webSettings.setEnableSmoothTransition(true)
        mWebView!!.scrollBarStyle= View.SCROLLBARS_INSIDE_OVERLAY



        mWebView!!.loadUrl("https://virtualclass.ug/")
    }

    override fun onBackPressed() {
        if (mWebView!!.canGoBack()){
            mWebView!!.goBack()
        }
        else{
            super.onBackPressed()
        }

    }
}
