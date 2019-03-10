package escholz.greenfield.net.catalog.models

data class CategoryAspectValue(
    val value: String,

    val valueConstraints: List<ValueConstraint>
)