package escholz.greenfield.net.catalog.models

/**
 * This type contains the name of a particular product attribute with a value in violation of eBay standards, and if
 * the name is not ASPECT_NAME (a product aspect), the values of the attribute that are in violation.
 */
data class ViolationProductAttribute(
    /**
     * The name of the product attribute type in the change request which is in violation, such as BRAND, CATEGORY,
     * or TITLE.
     * <p />
     * Note: If the value of this field is ASPECT_NAME, see violations.aspectsValues for violation information.
     *
     * @see <a href='https://developer.ebay.com/devzone/rest/api-ref/catalog/types/ProductAttributeName.html'>eBay API documentation</a>
     */
    val name: String,

    /**
     * Not returned if the value of name is ASPECT_NAME (see instead violations.aspectsValues). This is a list of the
     * named attribute's values that are in violation.
     */
    val values: List<String>
)