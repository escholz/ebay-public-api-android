package escholz.greenfield.net.catalog.models

/**
 * This type contains information about a correction that eBay has applied to the suggested product in a change request.
 */
data class Correction(
    /**
     * Returned only if the value of corrections.productAttribute.attributeName is ASPECT_NAME. Contains the name and
     * values of a product aspect that has been corrected by eBay in this change request.
     */
    val description: CorrectionAspectValues,

    /**
     * The eBay-assigned identifier of the correction type for this correction.
     */
    val correctionCode: String,

    /**
     * Contains the name of a particular product attribute with an incorrect value, and if the name is not ASPECT_NAME
     * (a product aspect), the incorrect and correct values of the attribute. For correction information about a
     * product aspect, see the corrections.aspectValues container.
     */
    val productAttribute: CorrectionProductAttribute,

    /**
     * The reason why this correction is required.
     */
    val reason: String
)