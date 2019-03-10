package escholz.greenfield.dagger

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import escholz.greenfield.net.auth.TokenApi
import escholz.greenfield.net.catalog.CatalogApi
import escholz.greenfield.net.catalog.models.ApiError
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import escholz.greenfield.net.interceptors.LoggingInterceptor
import okhttp3.ResponseBody
import retrofit2.Converter

@Module
class ServiceModule {
    @Provides
    fun providesOkHttpClient(loggingInterceptor: LoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Named("Auth")
    fun providesAuthGsonInstance(): Gson {
        return GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    }

    @Provides
    // TODO: Create a Qualifier for this
    @Named("Auth")
    fun providesAuthEndpoint(okHttp: OkHttpClient, @Named("Auth") gson: Gson): Retrofit {
        val baseUrl = "https://api.ebay.com"
        val rootPath = "/identity/v1/"
        return Retrofit.Builder()
            .client(okHttp)
            // TODO: Extract baseURL from endpoint overrides
            .baseUrl(baseUrl + rootPath)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun providesOAuthTokenApi(@Named("Auth") endpoint: Retrofit): TokenApi {
        return endpoint.create(TokenApi::class.java)
    }

    @Provides
    @Named("Catalog")
    fun providesCategoryEndpoint(okHttp: OkHttpClient): Retrofit {
        // TODO: Move into environment-based selection, may want to have different rootPath as well
        val baseUrl = "https://api.ebay.com"
        val rootPath = "/commerce/catalog/v1/"
        return Retrofit.Builder()
            .client(okHttp)
            .baseUrl(baseUrl + rootPath)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesCatalogApi(@Named("Catalog") endpoint: Retrofit): CatalogApi {
        return endpoint.create(CatalogApi::class.java)
    }

    @Provides
    fun providesCatalogErrorConverter(@Named("Catalog") endpoint: Retrofit): Converter<ResponseBody, ApiError> {
        return endpoint.responseBodyConverter<ApiError>(ApiError::class.java, arrayOf<Annotation>())
    }
}