package escholz.greenfield.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class InjectableViewModelProviderFactory
    @Inject
    constructor(private val viewModels: MutableMap<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>)
: ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = viewModels[modelClass] ?:
        viewModels.asIterable().firstOrNull { modelClass.isAssignableFrom(it.key) }?.value
        ?: throw IllegalArgumentException("unknown model class " + modelClass)

        return try {
            viewModel.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}