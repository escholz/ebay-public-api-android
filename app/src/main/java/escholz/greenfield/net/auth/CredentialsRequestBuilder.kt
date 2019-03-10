package escholz.greenfield.net.auth

import javax.inject.Inject

class CredentialsRequestBuilder
    @Inject
    constructor() {
    companion object {
        const val AUTHORIZATION_CODE_GRANT_TYPE = "authorization_code"
    }
    private var grantType: String? = null
    private var redirectUri: String? = null
    private var scope: String? = null
    private var code: String? = null

    fun grantType(value: String): CredentialsRequestBuilder {
        grantType = value
        return this
    }

    fun redirectUri(value: String): CredentialsRequestBuilder {
        redirectUri = value
        return this
    }

    fun scope(value: String): CredentialsRequestBuilder {
        scope = value
        return this
    }

    fun code(value: String): CredentialsRequestBuilder {
        code = value
        return this
    }

    fun build(): String {
        val building = HashSet<String>()
        if (!grantType.isNullOrEmpty())
            building += "grant_type=$grantType"
        if (!code.isNullOrEmpty())
            building += "code=$code"
        if (!redirectUri.isNullOrEmpty())
            building += "redirect_uri=$redirectUri"
        if (!scope.isNullOrEmpty())
            building += "scope=$scope"
        return building.joinToString("&")
    }
}