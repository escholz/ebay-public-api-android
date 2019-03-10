package escholz.greenfield.net.catalog.models

/**
 * This type contains a value of a given eBay product aspect which must be corrected, along with the correct value.
 */
data class CorrectionAspectValue(
    /**
     * The aspect's correct value
     */
    val newValue: String,

    /**
     * The aspect's current incorrect value.
     */
    val value: String
)