package escholz.greenfield.dagger

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import escholz.greenfield.ui.SignInViewModel

@Module(includes = arrayOf(ViewModelProviderModule::class))
abstract class SignInFragmentModule {
    @Binds
    @IntoMap
    @ViewModelKey(SignInViewModel::class)
    abstract fun bindSignInViewModel(viewModel: SignInViewModel): ViewModel
}