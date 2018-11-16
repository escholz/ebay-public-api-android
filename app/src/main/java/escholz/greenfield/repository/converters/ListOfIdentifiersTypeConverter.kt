package escholz.greenfield.repository.converters

import androidx.room.TypeConverter

class ListOfIdentifiersTypeConverter {

    @TypeConverter
    fun toString(input: List<String>): String {
        return input.joinToString(",")
    }

    @TypeConverter
    fun toList(input: String): List<String> {
        return input.split(",").map { it.trim() }
    }
}