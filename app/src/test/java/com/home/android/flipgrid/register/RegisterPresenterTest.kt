package com.home.android.flipgrid.register

import com.home.android.flipgrid.bundle.SubmissionDataBundle
import org.junit.Test

import org.junit.Assert.*
import org.mockito.kotlin.*

class RegisterPresenterTest {

    private val presenter = RegisterPresenter()
    private val view: RegisterContract.View = mock()
    private val router: RegisterContract.Router = mock()

    @Test
    fun submitButton_WhenEmailOrPasswordIsEmpty() {
        presenter.onViewAttached(view, router)
        val submitDataModel = SubmissionDataBundle("", "", "", "")

        presenter.submitButton(submitDataModel)
        verify(router, never()).goToProfilePage(any())
    }

    @Test
    fun submitButton_WhenDataModelHasEmailAndPassword(){
        presenter.onViewAttached(view, router)
        val submitDataModel = SubmissionDataBundle("", "someEmailAddress", "somePassword", "")

        presenter.submitButton(submitDataModel)
        verify(router).goToProfilePage(any())
    }

    @Test
    fun onViewAttached() {
        presenter.onViewAttached(view, router)
        assertEquals(view, presenter.getView())
        assertEquals(router, presenter.getRouter())
    }

    @Test
    fun clear() {
        presenter.clear()
        assertEquals(null, presenter.getView())
        assertEquals(null, presenter.getRouter())
    }
}