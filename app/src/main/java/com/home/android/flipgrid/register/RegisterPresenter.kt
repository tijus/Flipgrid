package com.home.android.flipgrid.register

import com.home.android.flipgrid.FlipGridFragmentManager
import com.home.android.flipgrid.SubmissionDataModel
import com.home.android.flipgrid.SubmissionDataModel.Companion.isValid

class RegisterPresenter: RegisterContract.Presenter {

    private var view: RegisterContract.View? = null
    private var router: RegisterContract.Router? = null

    override fun submitButton(submissionDataModel: SubmissionDataModel) {
        if (submissionDataModel.isValid()) {
            router?.goToProfilePage(submissionDataModel)
        } else {
            view?.showError()
        }
    }

    override fun onViewAttached(
        view: RegisterContract.View,
        fgFragmentManager: FlipGridFragmentManager
    ) {
        this.view = view
        this.router = RegisterRouter(fgFragmentManager)
    }

    override fun clear() {
        view = null
        router = null
    }
}