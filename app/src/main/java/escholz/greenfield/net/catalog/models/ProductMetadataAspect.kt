package escholz.greenfield.net.catalog.models

data class ProductMetadataAspect(
    val aspectHelpText: String,

    val constraint: ProductAspectConstraint,

    val droppable: Boolean,

    val name: String,

    val values: List<ProductAspectValue>,

    val valuesAssociatedWithProduct: List<String>
)