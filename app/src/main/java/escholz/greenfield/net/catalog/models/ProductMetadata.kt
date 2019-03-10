package escholz.greenfield.net.catalog.models

data class ProductMetadata(
    val aspects: List<ProductMetadataAspect>,

    val brand: ProductIdentifierForProductMetadata,

    val ean: ProductIdentifierForProductMetadata,

    val isbn: ProductIdentifierForProductMetadata,

    val mpn: ProductIdentifierForProductMetadata,

    val upc: ProductIdentifierForProductMetadata
)