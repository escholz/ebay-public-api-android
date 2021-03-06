package escholz.greenfield.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import escholz.greenfield.R
import escholz.greenfield.net.auth.UserTokenProvider
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {
    companion object {
        private val rootFragmentTag: String = "homeFragment"
    }

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProvider.Factory

    @Inject
    lateinit var homeFragmentProvider: Provider<HomeFragment>

    @Inject
    lateinit var signInFragmentProvider: Provider<SignInFragment>

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity_layout)

        viewModel = ViewModelProviders.of(this, viewModelProviderFactory)
            .get(MainActivityViewModel::class.java)

        if (supportFragmentManager.backStackEntryCount <= 0) {
            val signInFragment = signInFragmentProvider.get()
            val arguments = Bundle()
            arguments.putStringArray(SignInFragment.EXTRA_SCOPES,
                arrayOf(UserTokenProvider.SELL_INVENTORY_SCOPE, UserTokenProvider.SELL_ACCOUNT_SCOPE))
            signInFragment.arguments = arguments
            supportFragmentManager.beginTransaction()
                .add(R.id.container, signInFragment, rootFragmentTag)
                .addToBackStack(rootFragmentTag)
                .commit()
        }
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }
}