package escholz.greenfield.dagger

import dagger.Module
import dagger.android.ContributesAndroidInjector
import escholz.greenfield.ui.MainActivity

@Module
abstract class UiModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun contributesMainActivity(): MainActivity
}