package escholz.greenfield.repository.dao

import androidx.room.*
import escholz.greenfield.repository.entities.Product

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.ROLLBACK)
    fun insert(product: Product) : Long

    @Update
    fun update(product: Product) : Int

    @Delete
    fun delete(product: Product) : Int

    @Query("SELECT * FROM products WHERE id = :id")
    fun findProductById(id: Int) : Product

    @Query("SELECT * FROM products WHERE epid = :epid")
    fun findProductByEpid(epid: String) : Product
}