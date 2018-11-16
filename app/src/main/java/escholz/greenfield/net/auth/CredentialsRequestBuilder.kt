package escholz.greenfield.net.auth

class CredentialsRequestBuilder() {
    private var grantType: String = ""
    private var redirectUri: String = ""
    private var scope: String = ""

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

    fun build(): String {
        return "$grantType&$redirectUri&$scope"
    }
}