package escholz.greenfield.dagger

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import escholz.greenfield.ui.FindProductBottomSheetDialogFragment
import escholz.greenfield.ui.HomeFragment
import escholz.greenfield.ui.HomeViewModel

@Module(includes = arrayOf(ViewModelProviderModule::class))
abstract class HomeFragmentModule {
    @Binds
    abstract fun bindsFragment(fragment: HomeFragment): Fragment

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindsHomeViewModel(viewModel: HomeViewModel): ViewModel

    @FragmentScope(2)
    @ContributesAndroidInjector(modules = arrayOf(FindProductBottomSheetDialogFragmentModule::class))
    abstract fun contributesFindProductBottomSheetDialogFragment(): FindProductBottomSheetDialogFragment

}