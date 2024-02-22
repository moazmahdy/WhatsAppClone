package com.example.auth.ui.otp.componant

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.auth.ui.otp.componant.FieldModifier.tfMainModifier
import com.example.core.ui.design.Borders
import com.example.core.ui.design.Dimens.small5
import com.example.core.ui.design.MainHeight
import com.example.core.ui.design.MainWidth

object FieldModifier {
    val tfMainModifier = Modifier
        .width(MainWidth.smallWidth75)
        .height(MainHeight.largeHeight80)
        .padding(small5)
        .shadow(
            elevation = 0.dp,
            shape = Borders.roundedCornerShape20,
        )
}

@Composable
fun Field (
    onValueChange: (String, String) -> String = { _, new -> new }
){

    val state = rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        modifier = tfMainModifier,
        singleLine = true,
        value = state.value,
        onValueChange = {
            val value = onValueChange(state.value, it)
            state.value = value
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        textStyle = LocalTextStyle.current.copy(
            fontSize = 22.sp,
            textAlign = TextAlign.Center
        )
    )
}