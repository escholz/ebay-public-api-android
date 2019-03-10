package escholz.greenfield.net.auth

import android.util.Base64
import javax.inject.Inject
import javax.inject.Provider

class BasicAuthProvider
    @Inject
    constructor() {
    fun get(clientId: String, clientSecret: String): String {
        return "Basic " + Base64.encodeToString("$clientId:$clientSecret".toByteArray(), Base64.NO_WRAP)
    }
}