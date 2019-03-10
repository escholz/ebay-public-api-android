package escholz.greenfield.net.auth

import escholz.greenfield.net.auth.models.Token
import kotlinx.coroutines.Deferred
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface TokenApi {
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("oauth2/token")
    fun getClientCredentials(@Header("Authorization") authHeader: String, @Body requestBody: RequestBody): Deferred<Response<Token>>

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("oauth2/token")
    fun getUserCredentials(@Header("Authorization") authHeader: String, @Body requestBody: RequestBody): Deferred<Response<Token>>
}