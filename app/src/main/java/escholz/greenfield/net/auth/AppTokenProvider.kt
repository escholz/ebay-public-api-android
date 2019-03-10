package escholz.greenfield.net.auth

import escholz.greenfield.BuildConfig
import escholz.greenfield.net.auth.models.Token
import escholz.greenfield.repository.dao.TokenDao
import kotlinx.coroutines.*
import okhttp3.MediaType
import okhttp3.RequestBody
import javax.inject.Inject
import javax.inject.Provider

class AppTokenProvider
    @Inject
    constructor(
        private val coroutineScope: CoroutineScope,
        private val tokenApi: TokenApi,
        private val basicAuthProvider: BasicAuthProvider,
        private val credentialsBuilder: Provider<CredentialsRequestBuilder>
    )
: Provider<Deferred<Token?>> {
    override fun get(): Deferred<Token?> = coroutineScope.async {
        withContext(Dispatchers.IO) {
            val body = credentialsBuilder.get()
                .grantType("client_credentials")
                .redirectUri(BuildConfig.EBAY_API_REDIRECT_URI)
                .scope("https://api.ebay.com/oauth/api_scope/commerce.catalog.readonly")
                .build()
            tokenApi.getClientCredentials(basicAuthProvider.get(BuildConfig.EBAY_API_CLIENT_ID, BuildConfig.EBAY_API_CLIENT_SECRET),
                RequestBody.create(MediaType.parse("text/plain"), body)).await().body()
        }
    }
}