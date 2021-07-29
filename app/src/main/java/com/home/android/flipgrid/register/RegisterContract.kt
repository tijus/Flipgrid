package com.home.android.flipgrid.register

import com.home.android.flipgrid.FlipGridFragmentManager
import com.home.android.flipgrid.SubmissionDataModel

interface RegisterContract {

    interface View {
        fun showError()
    }

    interface Presenter {
        fun onViewAttached(view: View, fgFragmentManager: FlipGridFragmentManager)
        fun clear()
        fun submitButton(submissionDataModel: SubmissionDataModel)
    }

    interface Router {
        fun goToProfilePage(submissionDataModel: SubmissionDataModel)
    }
}