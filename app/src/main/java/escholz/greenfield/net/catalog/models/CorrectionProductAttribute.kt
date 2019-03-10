package escholz.greenfield.net.catalog.models

/**
 * Contains information about a particular product attribute with an incorrect value.
 */
data class CorrectionProductAttribute(
    /**
     * The name of the product attribute type in the change request which requires correction, such as BRAND, CATEGORY,
     * or TITLE.
     * <p />
     * Note: If the value of this field is ASPECT_NAME, see corrections.aspectValues for correction information.
     *
     * @see <a href='https://developer.ebay.com/devzone/rest/api-ref/catalog/types/ProductAttributeName.html'>eBay API documentation</a>
     */
    val attributeName: String,

    /**
     * Not returned if the value of attributeName is ASPECT_NAME (see instead corrections.aspectValues). This is the
     * named attribute's correct value.
     */
    val newValue: String,

    /**
     * Not returned if the value of attributeName is ASPECT_NAME (see instead corrections.aspectValues). This is the
     * named attribute's current incorrect value.
     */
    val value: String
)
