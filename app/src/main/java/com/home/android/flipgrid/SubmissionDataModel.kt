package com.home.android.flipgrid

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SubmissionDataModel(
    val firstName: String,
    val emailAddress: String,
    val password: String,
    val webAddress: String
): Parcelable {

    companion object {
        fun SubmissionDataModel.isValid(): Boolean {
            if (emailAddress.isBlank() || password.isBlank())
                return false
            return true
        }
    }
}
