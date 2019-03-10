package escholz.greenfield.net.catalog.models

/**
 * This type defines the fields that can be returned in an error.
 */
data class ApiError(
    /**
     * Identifies the type of error.
     */
    val category: String,

    /**
     * Name for the primary system where the error occurred. This is relevant for application errors.
     */
    val domain: String,

    /**
     * A unique number to identify the error.
     */
    val errorId: Int,

    /**
     * An array of request elements most closely associated to the error.
     */
    val inputRefIds: List<String>,

    /**
     * A more detailed explanation of the error.
     */
    val longMessage: String,

    /**
     * Information on how to correct the problem, in the end user's terms and language where applicable.
     */
    val message: String,

    /**
     * An array of request elements most closely associated to the error.
     */
    val outputRefIds: List<String>,

    /**
     * An array of name/value pairs that describe details the error condition. These are useful when multiple errors
     * are returned.
     */
    val parameters: List<ErrorParameter>,

    /**
     * Further helps indicate which subsystem the error is coming from. System subcategories include: Initialization,
     * Serialization, Security, Monitoring, Rate Limiting, etc.
     */
    val subdomain: String
)