package escholz.greenfield.net.catalog.models

data class Product(
    val additionalImages: List<Image>,

    val aspects: List<Aspect>,

    val brand: String,

    val description: String,

    val ean: List<String>,

    val epid: String,

    val gtin: List<String>,

    val image: Image,

    val isbn: List<String>,

    val mpn: List<String>,

    val otherApplicableCategoryIds: List<String>,

    val primaryCategoryId: String,

    val productWebUrl: String,

    val title: String,

    val upc: List<String>,

    val version: String
)