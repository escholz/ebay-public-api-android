package escholz.greenfield.net.auth

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface OAuthTokenService {
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("/identity/v1/oauth2/token")
    fun getClientCredentials(@Header("Authorization") authHeader: String, @Body requestBody: String): Call<TokenGrant>
}