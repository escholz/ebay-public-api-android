package escholz.greenfield.dagger

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Binds
import dagger.Module
import dagger.Provides
import escholz.greenfield.App
import escholz.greenfield.Environment
import escholz.greenfield.ProductionEnvironment
import javax.inject.Singleton

@Module(includes = [ EnvironmentsModule::class ])
class AppModule(val app: App) {
    @Provides
    @Singleton
    fun provideApp(): Application {
        return app
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences("app", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providesEnvironment(environments: @JvmSuppressWildcards Set<Environment>, sharedPreferences: SharedPreferences): Environment {
        val environmentPreference = sharedPreferences.getString("environment", "")
        return environments.find { it.name == environmentPreference } ?: ProductionEnvironment()
    }
}