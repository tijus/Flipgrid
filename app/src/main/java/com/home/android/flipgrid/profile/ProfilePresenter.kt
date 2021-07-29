package com.home.android.flipgrid.profile

import com.home.android.flipgrid.FlipGridFragmentManager

class ProfilePresenter: ProfileContract.Presenter {

    private var router: ProfileContract.Router? = null
    private var view: ProfileContract.View? = null

    override fun onViewAttached(
        view: ProfileContract.View,
        fragmentManager: FlipGridFragmentManager
    ) {
        this.view = view
        router = ProfileRouter(fragmentManager)
    }

    override fun onWebSectionClick(webUrl: String) {
        var url = webUrl
        if (!url.startsWith(HTTP) && !url.startsWith(HTTPS)) {
            url = "$HTTPS$url"
        }
        router?.openWebPage(url)
    }

    companion object {
        private const val HTTPS = "https://"
        private const val HTTP = "http://"
    }
}