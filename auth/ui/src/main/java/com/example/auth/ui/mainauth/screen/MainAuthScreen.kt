package com.example.auth.ui.mainauth.screen

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.auth.ui.mainauth.componant.AuthButton
import com.example.auth.ui.mainauth.componant.AuthTextField
import com.example.auth.ui.viewmodel.AuthViewModel
import com.example.core.domain.util.Resource

@Composable
fun MainAuthScreen(
    navController: NavHostController,
    viewModel: AuthViewModel = hiltViewModel()
) {

    val activity =  LocalContext.current as Activity

//    LaunchedEffect(key1 = true) {
//        viewModel.sendCode("+201066660496", activity = activity)
//    }

    var phoneText by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Enter your phone Number",
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            AuthTextField(
                text = phoneText,
                onValueChange = { phoneText = it },
                label = "Phone Number"
            )
            Spacer(modifier = Modifier.height(5.dp))

            val signUpResponse by viewModel.sendCodeResponse.collectAsState()

            AuthButton(
                onClick = {
                    viewModel.sendCode("+2${phoneText}", activity)
                }
            )

            when (signUpResponse) {
                is Resource.Loading -> CircularProgressIndicator()
                is Resource.Success -> {
                    if ((signUpResponse as Resource.Success<Boolean>).data) {
                        LaunchedEffect(key1 = true) {
                            navController.navigate(route = "OTPScreen")
                        }
                    } else {
                        Text(text = "Failed to send OTP")
                    }
                }
                is Resource.Error -> {
                    Text(text = "Error: ${(signUpResponse as Resource.Error).message}")
                }
                else -> {}
            }

        }
    }
}