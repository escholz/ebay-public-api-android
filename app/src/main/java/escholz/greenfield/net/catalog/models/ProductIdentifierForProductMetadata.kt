package escholz.greenfield.net.catalog.models

data class ProductIdentifierForProductMetadata(
    val constraint: ProductIdentifierConstraint,

    val valueAssociatedWithProduct: String,

    val values: List<String>
)