package escholz.greenfield.net.catalog.models

/**
 * This type provides details of conflicting products, corrections required, or violations that were discovered in a
 * change request.
 */
data class ProcessResolution(
    /**
     * Contains information about one or more existing products with identifying information that matches or
     * intersects with the suggested product. For each conflicting product, the difference is in the presence or value
     * of one or more product aspects. If the seller accepts the aspects and their values of the conflicting product
     * (such as a color value of scarlet instead of crimson), that product can be adopted by the seller instead of the
     * suggested product. If the seller does not accept any of the conflicting products as is, you can submit a change
     * request to update one of them, or to create a new product for which identifying information doesn't overlap with
     * an existing product enough to produce a conflict.
     */
    val conflictingProducts: List<ConflictingProduct>,

    /**
     * Contains information about one or more corrections to this change request that eBay has applied to the new or
     * updated product. Sellers can accept these corrections by adopting the product, which is identified by the
     * {@link #epid} field.
     */
    val corrections: List<Correction>,

    /**
     * Returned only if the value of changeRequestStatus is APPROVED or APPROVED_WITH_MODIFICATIONS; this is the eBay
     * identifier of the resulting product.
     */
    val epid: String,

    /**
     * The URI of the getProduct call request that retrieves this product's details.
     * <p />
     * This field is returned under one of the following conditions:
     * <ul>
     * <li>The value of changeRequestType is PRODUCT_UPDATE.</li>
     * <li>The value of changeRequestType is PRODUCT_CREATION, and the value of changeRequestStatus is APPROVED or
     * APPROVED_WITH_MODIFICATIONS.</li>
     * </ul>
     */
    val productHref: String,

    /**
     * Contains information about one or more violations in the values of the suggested product's aspects or fixed
     * attributes.
     */
    val violations: List<Violation>
)