package com.home.android.flipgrid.profile

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.home.android.flipgrid.MainActivity
import com.home.android.flipgrid.R
import com.home.android.flipgrid.bundle.SubmissionDataBundle

class ProfileFragment : Fragment(R.layout.fragment_profile), ProfileContract.View {

    private var tvHeaderText: TextView? = null
    private var tvWebAddress: TextView? = null
    private var tvFirstName: TextView? = null
    private var tvEmailAddress: TextView? = null

    private var presenter: ProfileContract.Presenter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (presenter == null) {
            presenter = ProfilePresenter()
        }

        presenter?.onViewAttached(this, ProfileRouter(activity as MainActivity))

        tvHeaderText = view.findViewById(R.id.profile_header)
        tvWebAddress = view.findViewById(R.id.profile_website)
        tvFirstName = view.findViewById(R.id.profile_name)
        tvEmailAddress = view.findViewById(R.id.profile_email)

        loadProfilePage()
    }

    private fun loadProfilePage() {
        arguments?.getParcelable<SubmissionDataBundle>(ARG_SUBMISSION)?.apply {
            tvHeaderText?.text = resources.getString(R.string.profile_header, firstName)
            if (webAddress.isBlank()) {
                tvWebAddress?.visibility = View.GONE
            }
            else {
                tvWebAddress?.apply {
                    text = webAddress
                    setOnClickListener {
                        presenter?.onWebSectionClick(webAddress)
                    }
                }
            }


            if (firstName.isBlank())
                tvFirstName?.visibility = View.GONE
            else
                tvFirstName?.text = firstName
            tvEmailAddress?.text = emailAddress
        }
    }

    companion object {

        private const val ARG_SUBMISSION = "arg_submission"

        fun newInstance(submissionDataBundle: SubmissionDataBundle) = ProfileFragment().apply {
            arguments= Bundle().apply {
                putParcelable(ARG_SUBMISSION, submissionDataBundle)
            }
        }
    }
}