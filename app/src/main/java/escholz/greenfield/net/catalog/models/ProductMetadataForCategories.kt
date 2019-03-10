package escholz.greenfield.net.catalog.models

data class ProductMetadataForCategories(
    val aspects: List<CategoryAspect>,

    val brand: ProductIdentifier,

    val ean: ProductIdentifier,

    val isbn: ProductIdentifier,

    val mpn: ProductIdentifier,

    val upc: ProductIdentifier
)