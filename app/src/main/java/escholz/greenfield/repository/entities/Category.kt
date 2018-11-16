package escholz.greenfield.repository.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "category",
    indices = [
        Index(value = arrayOf("parent_id"))
    ]
)
data class Category(
    @PrimaryKey var id: Int,
    @ColumnInfo(name = "parent_id") var parentId: Int?,
    var name: String?
)