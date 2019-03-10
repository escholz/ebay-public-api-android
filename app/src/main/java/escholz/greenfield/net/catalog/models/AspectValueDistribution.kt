package escholz.greenfield.net.catalog.models

data class AspectValueDistribution(
    val localizedAspectValue: String,

    val matchCount: Int,

    val refinementHref: String
)