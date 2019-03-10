package escholz.greenfield.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import escholz.greenfield.BuildConfig
import escholz.greenfield.Environment
import escholz.greenfield.net.auth.UserTokenProvider
import escholz.greenfield.repository.dao.TokenDao
import escholz.greenfield.repository.entities.Token
import kotlinx.coroutines.*
import okhttp3.HttpUrl
import java.util.*
import javax.inject.Inject
import javax.inject.Provider

class SignInViewModel
    @Inject
    constructor(
        private val environment: Environment,
        private val coroutineScope: CoroutineScope,
        private val userTokenProvider: UserTokenProvider,
        private val tokenDao: Provider<TokenDao>
    )
: ViewModel() {
    enum class Status { UNINITIALIZED, AUTHORIZING, AUTHORIZED, AUTHENTICATING, AUTHENTICATED, ERROR }

    // TODO: Regenerate on initialization in case login is reset or not completed the first time
    val nonce: String = UUID.randomUUID().toString()

    var scopes: Array<out String>? = null

    private val status = MutableLiveData<Status>()

    fun getStatus(): LiveData<Status> {
        if (status.value == null)
            status.value = Status.UNINITIALIZED
        return status
    }

    fun getHost(): String = environment.baseSignInUrl

    fun getUrl(): String = HttpUrl.Builder()
        .scheme("https")
        .host(getHost())
        .addPathSegment("authorize")
        .addQueryParameter("client_id", BuildConfig.EBAY_API_CLIENT_ID)
        .addQueryParameter("redirect_uri", BuildConfig.EBAY_API_REDIRECT_URI)
        .addQueryParameter("response_type", "code")
        .addQueryParameter("state", nonce)
        .addEncodedQueryParameter("scope", scopes?.joinToString(" "))
        .build()
        .toString()

    private fun authenticate(authenticationKey: String) = coroutineScope.launch {
        status.value = Status.AUTHENTICATING
        val id = withContext(Dispatchers.IO) {
            val token = userTokenProvider.get(authenticationKey)
            tokenDao.get().insert(
                Token(
                    accessToken = token?.accessToken!!,
                    expiresIn = token.expiresIn,
                    refreshToken = token.refreshToken,
                    tokenType = token.tokenType,
                    scope = (scopes ?: arrayOf()).toList(),
                    environment = environment.name
                )
            )
        }
        if (id > 0)
            status.value = Status.AUTHENTICATED
        else
            status.value = Status.ERROR
    }

    fun visitedUrl(url: String?) {
        if (url.isNullOrEmpty())
            return
        if (url.startsWith("https://www.ebay.com/ws/eBayISAPI.dll?SignIn")) {
            status.value = Status.AUTHORIZING
        } else if (url.startsWith("https://signin.ebay.com/ws/eBayISAPI.dll?VAppJanessa")) {
            status.value = Status.AUTHORIZING
        } else if (url.startsWith("https://signin.ebay.com/ws/eBayISAPI.dll?ThirdPartyAuthSucessFailure&isAuthSuccessful=true")) {
            status.value = Status.AUTHORIZED
            val authenticationKey = HttpUrl.parse(url)?.queryParameter("code")
            if (authenticationKey.isNullOrEmpty()) {
                status.value = Status.ERROR
            } else {
                authenticate(authenticationKey)
            }
        } else {
            status.value = Status.ERROR
        }
    }
}