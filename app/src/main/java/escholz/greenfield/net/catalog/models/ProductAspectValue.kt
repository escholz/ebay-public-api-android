package escholz.greenfield.net.catalog.models

data class ProductAspectValue(
    val value: String,

    val valueConstraints: List<ValueConstraint>
)