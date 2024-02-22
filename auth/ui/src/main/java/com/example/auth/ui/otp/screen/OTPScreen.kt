package com.example.auth.ui.otp.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.auth.ui.otp.componant.OTPRow
import com.example.core.ui.design.Dimens
import com.example.core.ui.design.Modifiers
import com.example.core.ui.design.fontSize.large24

@Composable
fun OTPScreen() {
    Box(
        modifier = Modifiers.fillMaxSize
    ) {
        Column(
            modifier = Modifiers.fillMaxSize.padding(vertical = Dimens.large15),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Enter Secret OTP",
                fontSize = large24
            )
            OTPRow()
        }
    }
}