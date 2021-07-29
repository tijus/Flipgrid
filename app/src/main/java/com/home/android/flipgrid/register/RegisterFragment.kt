package com.home.android.flipgrid.register

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.res.TypedArrayUtils.getText
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.home.android.flipgrid.MainActivity
import com.home.android.flipgrid.R
import com.home.android.flipgrid.SubmissionDataModel


class RegisterFragment : Fragment(R.layout.fragment_register), RegisterContract.View {

    private var presenter: RegisterPresenter? = null

    private var submitButton: Button? = null
    private var firstNameTextView: TextInputLayout? = null
    private var emailAddressTextView: TextInputLayout? = null
    private var passwordTextView: TextInputLayout? = null
    private var webAddress: TextInputLayout? = null
    private var requiredSubText: TextView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (presenter == null)
            presenter = RegisterPresenter()

        presenter?.onViewAttached(this, activity as MainActivity)


        firstNameTextView = view.findViewById(R.id.first_name)
        emailAddressTextView = view.findViewById(R.id.email)
        passwordTextView = view.findViewById(R.id.password)
        webAddress = view.findViewById(R.id.website)
        requiredSubText = view.findViewById(R.id.required_text)

        submitButton = view.findViewById<Button>(R.id.submit_button).apply {
            setOnClickListener {
                presenter?.submitButton(
                    SubmissionDataModel(
                        firstNameTextView?.getText().toString(),
                        emailAddressTextView?.getText().toString(),
                        passwordTextView?.getText().toString(),
                        webAddress?.getText().toString()
                    )
                )
            }
        }
    }

    override fun onPause() {
        presenter?.clear()
        presenter = null
        super.onPause()
    }

    override fun showError() {
        requiredSubText?.setTextColor(resources.getColor(R.color.fg_error_state, null))
        emailAddressTextView?.error = resources.getString(R.string.error_email)
        passwordTextView?.error = resources.getString(R.string.error_password)
    }

    companion object {

        @JvmStatic
        fun newInstance() = RegisterFragment()

        fun TextInputLayout?.getText(): Editable? {
            return this?.editText?.text
        }
    }


}