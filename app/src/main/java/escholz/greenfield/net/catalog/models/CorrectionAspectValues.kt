package escholz.greenfield.net.catalog.models

/**
 * This type identifies a product aspect that requires correction in a catalog change request, along with its aspect
 * values that must be corrected.
 */
data class CorrectionAspectValues(
    /**
     * The localized name of this product aspect that requires correction, such as Model Number, Size, or Color.
     */
    val aspectName: String,

    /**
     * A list of one or more values of this product aspect that must be corrected.
     */
    val values: List<CorrectionAspectValue>
)