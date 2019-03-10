package escholz.greenfield.net.catalog.models

data class ProductAspectConstraint(
    val aspectDataType: String,

    val aspectFormat: String,

    val aspectMode: String,

    val aspectRequired: Boolean,

    val importance: String,

    val productToAspectCardinality: String
)