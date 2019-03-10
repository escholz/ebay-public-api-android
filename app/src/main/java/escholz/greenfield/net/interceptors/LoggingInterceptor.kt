package escholz.greenfield.net.interceptors

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import okio.Buffer
import java.io.IOException
import javax.inject.Inject

class LoggingInterceptor
    @Inject
    constructor()
: Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val t1 = System.nanoTime()
        val buffer = Buffer()
        request.body()?.writeTo(buffer)
        Log.i("RequestLog",
            String.format(
                "Sending request %s on %s%n%s%n%s",
                request.url(),
                chain.connection(),
                request.headers(),
                buffer.readUtf8()
            )
        )

        val response = chain.proceed(request)

        val t2 = System.nanoTime()
        Log.i("ResponseLog",
            String.format(
                "Received %d response for %s in %.1fms%n%s%n%s",
                response.code(),
                response.request().url(),
                (t2 - t1) / 1e6,
                response.headers(),
                response.peekBody(1000).string()
            )
        )

        return response
    }
}