package escholz.greenfield.net.catalog.models

data class ValueConstraint(
    val applicableForAspectName: String,

    val applicableForAspectValues: List<String>
)