package escholz.greenfield.net.catalog.models

/**
 * This type contains information about an existing catalog product that presents a conflict with a seller's suggested
 * product.
 */
data class ConflictingProduct(
    /**
     * The eBay assigned identifier of this conflict.
     */
    val conflictCode: String,

    /**
     * Contains information about one or more aspects of the conflicting product, which the seller's change request
     * either duplicates or provides similar values. The seller should either accept the conflicting product's aspects
     * and values and adopt the product as is, or submit a change request to create or update a product that doesn't
     * conflict with an existing product record.
     */
    val differentiatingAspects: List<ProductAspect>,

    /**
     * The eBay product ID of the conflicting catalog product.
     */
    val epid: String,

    /**
     * The reason for this conflict.
     */
    val reason: String
)