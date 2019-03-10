package escholz.greenfield.net.auth

import escholz.greenfield.BuildConfig
import escholz.greenfield.net.auth.models.Token
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Response
import javax.inject.Inject

class UserTokenProvider
    @Inject
    constructor(
        private val basicAuthProvider: BasicAuthProvider,
        private val credentialsRequestBuilder: CredentialsRequestBuilder,
        private val tokenApi: TokenApi
    ) {
    companion object {
        const val SELL_ACCOUNT_SCOPE = "https://api.ebay.com/oauth/api_scope/sell.account"
        const val SELL_INVENTORY_SCOPE = "https://api.ebay.com/oauth/api_scope/sell.inventory"
    }

    suspend fun get(authenticationCode: String): Token? {
        val response: Response<Token> = tokenApi.getUserCredentials(
            basicAuthProvider.get(BuildConfig.EBAY_API_CLIENT_ID, BuildConfig.EBAY_API_CLIENT_SECRET),
            RequestBody.create(MediaType.parse("text/plain"),
                credentialsRequestBuilder
                    .grantType(CredentialsRequestBuilder.AUTHORIZATION_CODE_GRANT_TYPE)
                    .code(authenticationCode)
                    .redirectUri(BuildConfig.EBAY_API_REDIRECT_URI)
                    .build()))
            .await()

        // TODO: Error Handling

        return response.body()
    }
}