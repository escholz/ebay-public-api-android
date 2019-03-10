package escholz.greenfield.dagger

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import escholz.greenfield.ui.HomeFragment
import escholz.greenfield.ui.MainActivityViewModel
import escholz.greenfield.ui.SignInFragment

@Module(
    includes = arrayOf(
        ViewModelProviderModule::class,
        CoroutineScopeModule::class
    )
)
abstract class MainActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel

    @FragmentScope(1)
    @ContributesAndroidInjector(modules = arrayOf(HomeFragmentModule::class))
    abstract fun contributesHomeFragment(): HomeFragment

    @FragmentScope(1)
    @ContributesAndroidInjector(modules = arrayOf(SignInFragmentModule::class))
    abstract fun contributesSignInFragment(): SignInFragment
}