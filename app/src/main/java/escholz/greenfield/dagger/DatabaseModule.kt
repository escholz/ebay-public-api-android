package escholz.greenfield.dagger

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.Reusable
import escholz.greenfield.repository.AppDatabase
import escholz.greenfield.repository.dao.ProductDao
import escholz.greenfield.repository.dao.TokenDao
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun connectDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "app").build()
    }

    @Provides
    @Singleton
    fun productDao(database: AppDatabase): ProductDao {
        return database.productDao()
    }

    @Provides
    @Singleton
    fun tokenDao(database: AppDatabase): TokenDao {
        return database.tokenDao()
    }
}