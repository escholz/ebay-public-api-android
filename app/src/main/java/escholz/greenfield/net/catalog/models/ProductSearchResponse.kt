package escholz.greenfield.net.catalog.models

data class ProductSearchResponse(
    val href: String,
    val next: String,
    val prev: String,
    val productSummaries: List<ProductSummary>,
    val refinement: Refinement,
    val limit: Int,
    val offset: Int,
    val total: Int
)