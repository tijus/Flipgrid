package com.home.android.flipgrid.register

import com.home.android.flipgrid.FlipGridFragmentManager

class RegisterPresenter(): RegisterContract.Presenter {

    private var view: RegisterContract.View? = null
    private var router: RegisterContract.Router? = null

    override fun submitButton() {
        router?.goToProfilePage()
    }

    override fun onViewAttached(
        view: RegisterContract.View,
        fgFragmentManager: FlipGridFragmentManager
    ) {
        this.view = view
        this.router = RegisterRouter(fgFragmentManager)
    }
}