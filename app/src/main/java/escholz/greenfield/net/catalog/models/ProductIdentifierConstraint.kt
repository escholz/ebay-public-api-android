package escholz.greenfield.net.catalog.models

data class ProductIdentifierConstraint(
    val importance: String,

    val mode: String,

    val required: Boolean
)