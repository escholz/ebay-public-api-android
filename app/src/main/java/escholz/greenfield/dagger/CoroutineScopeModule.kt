package escholz.greenfield.dagger

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

@Module
class CoroutineScopeModule {
    @Provides
    fun providesCoroutineScope(context: CoroutineContext): CoroutineScope {
        return CoroutineScope(context)
    }

    @Provides
    fun providesCoroutineContext(job: Job): CoroutineContext {
        return Dispatchers.Main + job
    }

    @Provides
    fun providesJob(): Job {
        return Job()
    }
}