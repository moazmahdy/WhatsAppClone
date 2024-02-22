package com.example.auth.domain.usecase

import android.app.Activity
import com.example.auth.domain.repo.AuthRepo
import com.google.firebase.auth.PhoneAuthCredential
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val authRepo: AuthRepo
){
    fun phoneNumberSignIn(
        phoneNumber: String,
        activity: Activity
    ) = authRepo.phoneNumberSignIn(
        phoneNumber = phoneNumber,
        activity = activity
    )

    fun isUserAuth() = authRepo.isUserAuth()

    fun getUserId() = authRepo.getUserId()

//    suspend fun signInWithAuthCredential(phoneAuthCredential: PhoneAuthCredential) =
//        authRepo.signInWithAuthCredential(phoneAuthCredential)
}