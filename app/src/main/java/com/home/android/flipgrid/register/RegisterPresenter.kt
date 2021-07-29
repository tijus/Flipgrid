package com.home.android.flipgrid.register

import androidx.annotation.RestrictTo
import com.home.android.flipgrid.bundle.SubmissionDataBundle
import com.home.android.flipgrid.bundle.SubmissionDataBundle.Companion.isValid

class RegisterPresenter: RegisterContract.Presenter {

    private var view: RegisterContract.View? = null
    private var router: RegisterContract.Router? = null

    override fun submitButton(submissionDataBundle: SubmissionDataBundle) {
        if (submissionDataBundle.isValid()) {
            router?.goToProfilePage(submissionDataBundle)
        } else {
            view?.showError()
        }
    }

    override fun onViewAttached(
        view: RegisterContract.View,
        router: RegisterContract.Router
    ) {
        this.view = view
        this.router = router
    }

    override fun clear() {
        view = null
        router = null
    }

    @RestrictTo(RestrictTo.Scope.TESTS)
    fun getView() = view


    @RestrictTo(RestrictTo.Scope.TESTS)
    fun getRouter() = router

}