package escholz.greenfield.net.catalog.models

data class AspectDistribution(
    val localizedAspectName: String,

    val aspectValueDistributions: List<AspectValueDistribution>
)