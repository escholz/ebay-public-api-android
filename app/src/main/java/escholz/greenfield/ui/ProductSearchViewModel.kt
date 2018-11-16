package escholz.greenfield.ui

import androidx.lifecycle.ViewModel
import escholz.greenfield.repository.dao.ProductDao
import javax.inject.Inject

class ProductSearchViewModel
    @Inject
    constructor(private val productDao: ProductDao)
: ViewModel() {

}