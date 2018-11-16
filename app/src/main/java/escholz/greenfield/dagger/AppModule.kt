package escholz.greenfield.dagger

import android.app.Application
import dagger.Module
import dagger.Provides
import escholz.greenfield.App
import javax.inject.Singleton

@Module
class AppModule(val app: App) {
    @Provides
    @Singleton
    fun provideApp(): Application {
        return app
    }
}