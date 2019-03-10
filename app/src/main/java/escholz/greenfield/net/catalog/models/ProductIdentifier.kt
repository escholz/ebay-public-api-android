package escholz.greenfield.net.catalog.models

data class ProductIdentifier(
    val constraint: ProductIdentifierConstraint,

    val values: List<String>
)