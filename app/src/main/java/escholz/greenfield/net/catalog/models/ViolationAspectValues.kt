package escholz.greenfield.net.catalog.models

/**
 * Contains the name of a product aspect that is in violation of eBay standards in a particular catalog change request,
 * along with its values that produced the violation.
 */
data class ViolationAspectValues(
    /**
     * The localized name of this product aspect that's in violation, such as Model Number, Size, or Color.
     */
    val aspectName: String,

    /**
     * A list of one or more values of this product aspect that are in violation of eBay standards.
     */
    val values: List<String>
)