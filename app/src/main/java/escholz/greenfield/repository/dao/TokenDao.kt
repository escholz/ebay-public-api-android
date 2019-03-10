package escholz.greenfield.repository.dao

import androidx.room.*
import escholz.greenfield.repository.entities.Token

@Dao
interface TokenDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(token: Token): Long

    @Delete
    fun delete(token: Token)

    @Query("SELECT * FROM token WHERE environment = :environment AND scope = :scope")
    fun findByEnvironmentAndScope(environment: String, scope: String): Token?
}