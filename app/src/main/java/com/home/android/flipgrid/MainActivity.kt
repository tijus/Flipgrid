package com.home.android.flipgrid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commitNow
import com.home.android.flipgrid.profile.ProfileFragment
import com.home.android.flipgrid.register.RegisterFragment

class MainActivity : AppCompatActivity(R.layout.activity_main), FlipGridFragmentManager {

    private var contentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  TODO: Save the register data into session / Shared Pref so that we directly route to profile page if already registered
        routeToFragment(RegisterFragment.newInstance())
    }

    override fun routeToFragment(fragment: Fragment) {
        supportFragmentManager.commitNow(true) {
            setReorderingAllowed(true)
            /* We only want to register once in a given session,
            so back press should exit the app once we have already registered */
            if (contentFragment == null) {
                add(R.id.fragment_container_view, fragment)
            } else {
                replace(R.id.fragment_container_view, fragment)
            }
            contentFragment = fragment
        }
    }

    override fun routeToWebView(webURl: String) {
        routeToFragment(WebViewFragment.newInstance(webURl))
    }
}