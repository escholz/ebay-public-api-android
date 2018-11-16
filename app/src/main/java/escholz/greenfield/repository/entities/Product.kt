package escholz.greenfield.repository.entities

import androidx.room.*

@Entity(
    tableName = "products",
    indices = [
        Index(value = arrayOf("primary_category_id"))
    ],
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("primary_category_id")
        )
    ]
)
data class Product(
    @PrimaryKey(autoGenerate = true) var id: Long,
    var epid: String?,
    var ean: List<String>,
    var gtin: List<String>,
    var isbn: List<String>,
    var mpn: List<String>,
    var upc: List<String>,
    var version: String,
    var title: String?,
    var brand: String?,
    var description: String?,
    var url: String?,
    @ColumnInfo(name = "primary_category_id") var primaryCategoryId: String?
)