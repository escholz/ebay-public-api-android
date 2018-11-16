package escholz.greenfield.net.auth

data class TokenGrant(
    val accessToken: String,
    val expiresIn: Long,
    val refreshToken: String,
    val tokenType: String
)