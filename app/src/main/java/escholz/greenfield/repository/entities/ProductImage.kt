package escholz.greenfield.repository.entities

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(
    tableName = "images",
    indices = [
        Index(value = arrayOf("product_id"))
    ],
    foreignKeys = [
        ForeignKey(
            entity = Product::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("product_id"),
            onDelete = CASCADE
        )
    ]
)
data class ProductImage(
    @PrimaryKey var id: Int?,
    @ColumnInfo(name = "product_id") var productId: Int?,
    var width: Int?,
    var height: Int?,
    var url: String
)