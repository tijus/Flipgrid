package com.home.android.flipgrid.profile

import com.home.android.flipgrid.FlipGridFragmentManager

class ProfileRouter(private val fragmentManager: FlipGridFragmentManager): ProfileContract.Router {

    override fun openWebPage(webUrl: String) {
        fragmentManager.routeToWebView(webUrl)
    }
}