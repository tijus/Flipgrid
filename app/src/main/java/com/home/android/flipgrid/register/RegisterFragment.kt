package com.home.android.flipgrid.register

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.home.android.flipgrid.MainActivity
import com.home.android.flipgrid.R


class RegisterFragment : Fragment(R.layout.fragment_register), RegisterContract.View {

    private var presenter: RegisterPresenter? = null

    private var submitButton: Button? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (presenter == null)
            presenter = RegisterPresenter()

        presenter?.onViewAttached(this, activity as MainActivity)

        submitButton = view.findViewById<Button>(R.id.submit_button).apply {
            setOnClickListener {
                presenter?.submitButton()
            }
        }
    }
    companion object {
        fun newInstance() = RegisterFragment()
    }
}