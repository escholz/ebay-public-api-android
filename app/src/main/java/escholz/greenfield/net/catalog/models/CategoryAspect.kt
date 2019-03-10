package escholz.greenfield.net.catalog.models

data class CategoryAspect(
    val aspectHelpText: String,

    val constraint: ProductAspectConstraint,

    val name: String,

    val values: List<CategoryAspectValue>
)