package escholz.greenfield.repository.dao

import androidx.room.*
import escholz.greenfield.repository.entities.Product

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(product: Product) : Long

    @Update
    fun update(product: Product) : Int

    @Delete
    fun delete(product: Product) : Int

    @Query("SELECT * FROM products WHERE id = :id")
    fun findById(id: Int) : Product

    @Query("SELECT * FROM products WHERE epid = :epid")
    fun findByEpid(epid: String) : Product
}