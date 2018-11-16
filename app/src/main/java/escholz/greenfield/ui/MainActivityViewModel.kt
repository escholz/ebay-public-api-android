package escholz.greenfield.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainActivityViewModel
    @Inject
    constructor(private val application: Application)
: ViewModel() {

}