package escholz.greenfield.dagger

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelProviderModule {
    @Binds
    abstract fun bindsViewModelProviderFactory(factory: InjectableViewModelProviderFactory) : ViewModelProvider.Factory
}