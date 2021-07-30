package com.home.android.flipgrid.bundle

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SubmissionDataBundle(
    val firstName: String,
    val emailAddress: String,
    val password: String,
    val webAddress: String
): Parcelable {

    companion object {
        fun SubmissionDataBundle.isValid(): Boolean {
            if (emailAddress.isBlank() || password.isBlank())
                return false
            return true
        }
    }
}
