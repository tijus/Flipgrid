package com.home.android.flipgrid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView

class WebViewFragment : Fragment(R.layout.fragment_web_view) {

    private var webView: WebView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(ARG_URL)?.let { webUrl ->
            webView = view.findViewById<WebView>(R.id.web_view).apply {
                loadUrl(webUrl)
            }
        }
    }

    companion object {

        private const val ARG_URL = "arg_url"
        @JvmStatic
        fun newInstance(webUrl: String) =
            WebViewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_URL, webUrl)
                }
            }
    }
}