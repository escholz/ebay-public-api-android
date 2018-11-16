package escholz.greenfield.dagger

import android.app.Application
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import escholz.greenfield.App
import escholz.greenfield.repository.AppDatabase
import kotlinx.coroutines.Deferred
import javax.inject.Singleton

@Component(
    modules = arrayOf(
        AndroidSupportInjectionModule::class,
        DatabaseModule::class,
        UiModule::class,
        AppModule::class
    )
)
@Singleton
interface AppComponent {
    fun inject(app: App)

    fun getApplication(): Application

    fun getAppDatabase(): AppDatabase
}