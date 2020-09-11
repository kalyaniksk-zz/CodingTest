package com.assignment.codingtest.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.assignment.codingtest.R
import kotlinx.android.synthetic.main.fragment_asset_webview.*


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class WebViewAssetFragment : Fragment() {

    val args: WebViewAssetFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_asset_webview, container, false)
    }
    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        loadUrl(args.url)
    }

    private fun loadUrl(url: String) {
        webView?.loadUrl(url)
    }
}