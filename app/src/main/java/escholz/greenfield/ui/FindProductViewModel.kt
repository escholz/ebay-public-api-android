package escholz.greenfield.ui

import android.util.Base64
import android.util.Base64.encodeToString
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import escholz.greenfield.net.auth.CredentialsRequestBuilder
import escholz.greenfield.net.auth.OAuthTokenService
import escholz.greenfield.net.auth.TokenGrant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.FileInputStream
import java.io.FileOutputStream
import java.security.KeyStore
import java.security.PrivateKey
import javax.crypto.SecretKey
import javax.crypto.spec.PBEKeySpec
import javax.inject.Inject

class FindProductViewModel @Inject constructor() : ViewModel() {
    companion object {
        // TODO: Make an object for IdentifierType
        val identifierTypes = arrayOf("EPID", "UPC", "EAN", "MPN", "ISBN", "GTIN")
        val identifierTypeHints = arrayOf("123448002203","","","","9783161484100","")
    }

    private val mutableStatus = MutableLiveData<UxStatus>()

    val status: LiveData<UxStatus> = mutableStatus

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
    }
}