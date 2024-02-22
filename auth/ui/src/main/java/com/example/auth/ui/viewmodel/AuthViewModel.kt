package com.example.auth.ui.viewmodel

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auth.domain.usecase.AuthUseCase
import com.example.core.domain.util.Resource
import com.example.core.domain.util.Resource.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
) : ViewModel() {

    private val _sendCodeResponse = MutableStateFlow<Resource<Boolean>>(Success(false))
    val sendCodeResponse: StateFlow<Resource<Boolean>> = _sendCodeResponse

    fun sendCode(
        phoneNumber: String,
        activity: Activity
        ) {
        viewModelScope.launch {
            try {
                _sendCodeResponse.value = Resource.Loading
                val result = authUseCase.phoneNumberSignIn(phoneNumber, activity).first()
                _sendCodeResponse.value = result
            } catch (e: Exception) {
                _sendCodeResponse.value = Resource.Error(e.message ?: "An error occurred")
            }
        }
    }
}