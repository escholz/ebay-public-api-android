package escholz.greenfield.dagger

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import escholz.greenfield.ui.FindProductViewModel

@Module(includes = arrayOf(ViewModelProviderModule::class))
abstract class FindProductBottomSheetDialogFragmentModule {
    @Binds
    @IntoMap
    @ViewModelKey(FindProductViewModel::class)
    abstract fun bindFindProductViewModel(viewModel: FindProductViewModel): ViewModel
}