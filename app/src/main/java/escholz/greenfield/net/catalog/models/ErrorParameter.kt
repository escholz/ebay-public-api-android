package escholz.greenfield.net.catalog.models

data class ErrorParameter(
    /**
     * The object of the error.
     */
    val name: String,

    /**
     * The value of the object.
     */
    val value: String
)