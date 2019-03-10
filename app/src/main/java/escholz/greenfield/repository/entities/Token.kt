package escholz.greenfield.repository.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "token",
    indices = [
        Index(value = arrayOf("environment", "scope"), unique = true)
    ]
)
data class Token(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var accessToken: String,
    var expiresIn: Long,
    var refreshToken: String,
    // TODO: Key off of tokenType as well for user vs app token?
    // TODO: Should I have some means of differentiating by user or since I'm requiring a new login anyway, just blow
    // TODO: away all user tokens when the user logs out?
    var tokenType: String,
    var environment: String,
    var scope: List<String>
)