package com.home.android.flipgrid.register

import com.home.android.flipgrid.FlipGridFragmentManager
import com.home.android.flipgrid.profile.ProfileFragment

// TODO: Can use dagger injection for injecting these things instead
class RegisterRouter(
    private val fgFragmentManager: FlipGridFragmentManager
) : RegisterContract.Router {

    override fun goToProfilePage() {
        fgFragmentManager.routeToFragment(ProfileFragment.newInstance())
    }
}