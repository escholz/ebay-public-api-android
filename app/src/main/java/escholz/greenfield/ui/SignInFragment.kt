package escholz.greenfield.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.AndroidSupportInjection
import escholz.greenfield.ui.SignInViewModel.Status.*
import escholz.greenfield.R
import okhttp3.HttpUrl
import javax.inject.Inject

class SignInFragment
    @Inject
    constructor()
: Fragment() {
    companion object {
        const val EXTRA_SCOPES: String = "escholz.greenfield.ui.scopes"
    }

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProvider.Factory

    private lateinit var viewModel: SignInViewModel

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(SignInViewModel::class.java)
        viewModel.scopes = savedInstanceState?.getStringArray(EXTRA_SCOPES)
        viewModel.getStatus().observe(viewLifecycleOwner, Observer { onStatusChanged(it) })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.sign_in_layout, container, false)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val webView = view.findViewById(R.id.webview) as WebView
        webView.webViewClient = object: WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                viewModel.visitedUrl(url)
            }
        }
    }

    private fun onStatusChanged(newStatus: SignInViewModel.Status) {
        when (newStatus) {
            UNINITIALIZED -> view?.findViewById<WebView>(R.id.webview)?.loadUrl(viewModel.getUrl())
            AUTHORIZING -> {} // TODO: May split this up more and handle onPageStarted as well to show an animation
            AUTHORIZED -> {}
            AUTHENTICATING -> {} // TODO: Indeterminate Progress Animation
            AUTHENTICATED -> {} // TODO: Redirect to where you were going or close to go back where we were
            ERROR -> {}
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putStringArray(EXTRA_SCOPES, viewModel.scopes)
    }
}