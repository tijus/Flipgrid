package com.home.android.flipgrid.register

import com.home.android.flipgrid.FlipGridFragmentManager

interface RegisterContract {

    interface View {

    }

    interface Presenter {
        fun submitButton()
        fun onViewAttached(view: View, fgFragmentManager: FlipGridFragmentManager)
    }

    interface Router {
        fun goToProfilePage()
    }
}