package com.example.auth.data.repoimpl

import android.app.Activity
import android.util.Log
import com.example.auth.domain.repo.AuthRepo
import com.example.core.domain.util.Resource
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseException
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@Singleton
class AuthRepoImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthRepo {

    val scope = CoroutineScope(Job() + Dispatchers.Main)
    override fun phoneNumberSignIn(
        phoneNumber: String,
        activity: Activity
        ): Flow<Resource<Boolean>> = channelFlow {
        try {
            trySend(Resource.Loading)
            val options = PhoneAuthOptions
                .newBuilder(auth)
                .setPhoneNumber(phoneNumber)
                .setTimeout(60, TimeUnit.SECONDS)
                .setActivity(activity)
                .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                        scope.launch {
                            signInWithAuthCredential(p0, activity = activity)
                            trySend(Resource.Success(true))
                            Log.e("A7A", p0.toString())
                        }
                    }

                    override fun onVerificationFailed(p0: FirebaseException) {
                        scope.launch {
                            Log.e("A7A1", p0.toString())
                            trySend(Resource.Error(p0.localizedMessage ?: "An Error Occurred"))
                        }
                    }

                    override fun onCodeSent(
                        verficationId: String,
                        p1: PhoneAuthProvider.ForceResendingToken
                    ) {
                        super.onCodeSent(verficationId, p1)
                    }
                })
                .build()
            PhoneAuthProvider.verifyPhoneNumber(options)
        } catch (e: Exception) {
            trySend(Resource.Error(e.localizedMessage ?: "An Error Occurred"))
        }
    }

    override fun isUserAuth(): Boolean {
        return auth.currentUser != null
    }

    override fun getUserId(): String {
        return auth.currentUser?.let {
            it.uid
        } ?: ""
    }

    override suspend fun signInWithAuthCredential(
        phoneAuthCredential: PhoneAuthCredential,
        activity: Activity
    ) {
        auth.signInWithCredential(phoneAuthCredential)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    Resource.Success(true)
                } else {
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        Resource.Error((task.exception as FirebaseAuthInvalidCredentialsException).localizedMessage)
                    }
                }
            }
    }
}