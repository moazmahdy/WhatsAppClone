package com.example.auth.ui.otp.componant

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable

@Composable
fun OTPRow() {
    Row {
        for (i in 1 until 6) {
            Field(
                onValueChange = { old, new ->
                    if (new.length > 1 || new.any { !it.isDigit() }) old else new
                }
            )
        }
    }
}