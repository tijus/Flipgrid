package com.home.android.flipgrid.register

import com.home.android.flipgrid.bundle.SubmissionDataBundle

interface RegisterContract {

    interface View {
        fun showError()
    }

    interface Presenter {
        fun clear()
        fun submitButton(submissionDataBundle: SubmissionDataBundle)
        fun onViewAttached(view: View, router: Router)
    }

    interface Router {
        fun goToProfilePage(submissionDataBundle: SubmissionDataBundle)
    }
}