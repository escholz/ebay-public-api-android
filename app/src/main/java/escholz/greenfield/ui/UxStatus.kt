package escholz.greenfield.ui

interface UxStatus {
    val type: Type
    val message: String

    enum class Type {
        NONE,
        INPUT_ERROR,
        LOADING,
        NOTICE,
    }
}