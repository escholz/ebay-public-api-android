package escholz.greenfield.net.catalog.models

/**
 * This type contains the name and values of a category aspect that is associated with a particular product.
 */
data class ProductAspect(
    /**
     * The name of the product aspect, such as Model Number, Size, or Color.
     */
    val name: String,

    /**
     * Required or returned if a value is provided for the name field. This is a list of one or more localized values
     * of this product aspect.
     */
    val values: List<String>
)