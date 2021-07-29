package com.home.android.flipgrid.profile

import com.home.android.flipgrid.FlipGridFragmentManager

interface ProfileContract {

    interface View
    interface Presenter
    interface Router {
        fun openWebPage(fragmentManager: FlipGridFragmentManager)
    }
}