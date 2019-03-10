package escholz.greenfield.net.catalog.models

/**
 * This type contains information about a violation of eBay standards in a change request.
 */
data class Violation(
    /**
     * Returned only if the value of productAttribute.name is ASPECT_NAME. Contains the name of a product aspect that
     * is in violation of eBay standards in this change request, along with its values that produced the violation.
     */
    val aspectsValues: ViolationAspectValues,

    /**
     * Contains the name of a particular product attribute with a value in violation of eBay standards, and if the name
     * is not ASPECT_NAME (a product aspect), the value of the attribute that's in violation of eBay standards.
     */
    val productAttribute: ViolationProductAttribute,

    /**
     * An explanation of the reason for this violation.
     */
    val reason: String,

    /**
     * The eBay-assigned identifier of the violation type of this violation.
     */
    val violationCode: String
)