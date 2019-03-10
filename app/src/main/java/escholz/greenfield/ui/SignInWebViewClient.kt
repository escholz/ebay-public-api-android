package escholz.greenfield.ui

import android.graphics.Bitmap
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import okhttp3.HttpUrl
import javax.inject.Inject

class SignInWebViewClient
    @Inject
    constructor()
: WebViewClient() {
    var authorizationKey: String? = null
        private set

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        return super.shouldOverrideUrlLoading(view, request)
    }

    override fun shouldInterceptRequest(view: WebView?, request: WebResourceRequest?): WebResourceResponse? {
        return super.shouldInterceptRequest(view, request)
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)

        val httpUrl = HttpUrl.parse(url!!)
        authorizationKey = httpUrl?.queryParameter("code")
    }
}