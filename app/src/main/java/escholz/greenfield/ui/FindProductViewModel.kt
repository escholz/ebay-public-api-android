package escholz.greenfield.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import escholz.greenfield.net.auth.AppTokenProvider
import escholz.greenfield.net.catalog.CatalogApi
import escholz.greenfield.net.catalog.models.ApiError
import escholz.greenfield.net.catalog.models.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Converter
import javax.inject.Inject

class FindProductViewModel
    @Inject
    constructor(
        private val tokenProvider: AppTokenProvider,
        private val catalogApi: CatalogApi,
        private val errorConverter: Converter<ResponseBody, ApiError>
    )
: ViewModel() {
    companion object {
        // TODO: Make an object for IdentifierType
        val identifierTypes = arrayOf("EPID", "UPC", "EAN", "MPN", "ISBN", "GTIN")
        val identifierTypeHints = arrayOf("123448002203","","","","9783161484100","")
    }

    private val mutableStatus = MutableLiveData<UxStatus>()
    private val mutableProduct = MutableLiveData<Product>()

    val status: LiveData<UxStatus> = mutableStatus

    val product: LiveData<Product> = mutableProduct

    fun identifierTypes(): Array<String> = identifierTypes

    fun identifierTypeHints(): Array<String> = identifierTypeHints

    var identifierType: LiveData<String> = MutableLiveData<String>()

    var identifierTypeHint: LiveData<String> = MutableLiveData<String>()

    fun setIdentifierType(value: String) {
        val mutableIdentifierType = identifierType as MutableLiveData<String>
        val mutableIdentifierTypeHint = identifierTypeHint as MutableLiveData<String>
        if (identifierTypes.contains(value)) {
            mutableIdentifierType.value = value
            mutableIdentifierTypeHint.value = identifierTypeHints[identifierTypes.indexOfFirst { it == value }]
        }
        else {
            mutableIdentifierType.value = identifierTypes[0]
            mutableIdentifierTypeHint.value = identifierTypeHints[0]
        }
    }

    var identifierValue: String = ""

    fun search() {
        GlobalScope.launch(Dispatchers.Default) {

            tokenProvider.get().await()?.apply {
                // TODO: Take value(s) from layout (change layout to only work with EPID or add findProduct)
                // TODO: post to LiveData
                mutableProduct.postValue(catalogApi.getProduct("Bearer $accessToken", "18025260500").await().body())
            }
        }
        // TODO: Look up product by identifier in productDao#findProduct
        // TODO: If it doesn't exist, launch coroutine to query via catalogApi#findProduct
        // TODO: Write back to productDao on the way out
        // TODO: If successful inform view (so it can dismiss and pass the reference_id back to parent to view)
    }
}