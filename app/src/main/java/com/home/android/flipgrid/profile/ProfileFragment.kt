package com.home.android.flipgrid.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.home.android.flipgrid.R
import com.home.android.flipgrid.SubmissionDataModel

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var tvHeaderText: TextView? = null
    private var tvWebAddress: TextView? = null
    private var tvFirstName: TextView? = null
    private var tvEmailAddress: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvHeaderText = view.findViewById(R.id.profile_header)
        tvWebAddress = view.findViewById(R.id.profile_website)
        tvFirstName = view.findViewById(R.id.profile_name)
        tvEmailAddress = view.findViewById(R.id.profile_email)

        loadProfilePage()
    }

    private fun loadProfilePage() {
        arguments?.getParcelable<SubmissionDataModel>(ARG_SUBMISSION)?.apply {
            tvHeaderText?.text = resources.getString(R.string.profile_header, firstName)
            if (webAddress.isBlank())
                tvWebAddress?.visibility = View.GONE
            else
                tvWebAddress?.text = webAddress

            if (firstName.isBlank())
                tvFirstName?.visibility = View.GONE
            else
                tvFirstName?.text = firstName
            tvEmailAddress?.text = emailAddress
        }
    }

    companion object {

        private const val ARG_SUBMISSION = "arg_submission"

        fun newInstance(submissionDataModel: SubmissionDataModel) = ProfileFragment().apply {
            arguments= Bundle().apply {
                putParcelable(ARG_SUBMISSION, submissionDataModel)
            }
        }
    }
}