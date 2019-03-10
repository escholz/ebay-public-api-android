package escholz.greenfield.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import escholz.greenfield.repository.converters.ListOfIdentifiersTypeConverter
import escholz.greenfield.repository.dao.ProductDao
import escholz.greenfield.repository.dao.TokenDao
import escholz.greenfield.repository.entities.Category
import escholz.greenfield.repository.entities.Product
import escholz.greenfield.repository.entities.ProductImage
import escholz.greenfield.repository.entities.Token

@Database(
    version = 1,
    exportSchema = false,
    entities = [
        Token::class,
        Product::class,
        ProductImage::class,
        Category::class
    ]
)
@TypeConverters(
    value = [
        ListOfIdentifiersTypeConverter::class
    ]
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun productDao(): ProductDao

    abstract fun tokenDao(): TokenDao
}