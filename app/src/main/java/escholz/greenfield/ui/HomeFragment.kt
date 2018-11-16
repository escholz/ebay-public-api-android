package escholz.greenfield.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import escholz.greenfield.R
import javax.inject.Inject
import javax.inject.Provider

class HomeFragment @Inject constructor(): Fragment(), HasSupportFragmentInjector {
    companion object {
        private val findProductFragmentTag: String = "findProduct"
    }

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var findProductFragmentProvider: Provider<FindProductBottomSheetDialogFragment>

    lateinit var viewModel: HomeViewModel

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_fragment_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)

        view?.findViewById<FloatingActionButton>(R.id.find_product_fab)?.setOnClickListener {
            (childFragmentManager.findFragmentByTag(findProductFragmentTag) as BottomSheetDialogFragment?
                ?: findProductFragmentProvider.get())
                .show(childFragmentManager, findProductFragmentTag)
        }
    }

    override fun onResume() {
        super.onResume()

        view?.findViewById<FloatingActionButton>(R.id.find_product_fab)?.show()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }
}