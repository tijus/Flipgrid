package com.home.android.flipgrid.profile

import com.home.android.flipgrid.FlipGridFragmentManager

interface ProfileContract {

    interface View
    interface Presenter {
        fun onViewAttached(view: View, router: Router)
        fun onWebSectionClick(webUrl: String)
    }
    interface Router {
        fun openWebPage(webUrl: String)
    }
}