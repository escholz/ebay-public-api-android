package escholz.greenfield.dagger

import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import escholz.greenfield.App
import javax.inject.Singleton

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        DatabaseModule::class,
        ServiceModule::class,
        UiModule::class,
        AppModule::class
    ]
)
@Singleton
interface AppComponent {
    fun inject(app: App)
}