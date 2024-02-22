package com.example.auth.domain.repo

import android.app.Activity
import com.example.core.domain.util.Resource
import com.google.firebase.auth.PhoneAuthCredential
import kotlinx.coroutines.flow.Flow
interface AuthRepo {

    fun phoneNumberSignIn(
        phoneNumber: String,
        activity: Activity
    ): Flow<Resource<Boolean>>

    fun isUserAuth(): Boolean

    fun getUserId(): String

    suspend fun signInWithAuthCredential(
        phoneAuthCredential: PhoneAuthCredential,
        activity: Activity
    )
}