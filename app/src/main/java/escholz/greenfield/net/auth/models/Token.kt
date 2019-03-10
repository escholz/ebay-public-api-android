package escholz.greenfield.net.auth.models

data class Token(
    val accessToken: String,
    val expiresIn: Long,
    val refreshToken: String,
    val tokenType: String
)