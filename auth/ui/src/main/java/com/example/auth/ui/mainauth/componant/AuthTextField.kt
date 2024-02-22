package com.example.auth.ui.mainauth.componant

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.unit.dp
import com.example.auth.ui.mainauth.componant.TextFieldModifier.tfMainModifier
import com.example.core.ui.design.Borders.roundedCornerShape20
import com.example.core.ui.design.Colors.colorTransparent
import com.example.core.ui.design.Colors.inputFieldContainerColor
import com.example.core.ui.design.Colors.mainTextColor
import com.example.core.ui.design.Dimens.large20
import com.example.core.ui.design.Dimens.medium12
import com.example.core.ui.design.MainHeight.extraLargeHeight100
import com.example.core.ui.design.MainHeight.largeHeight80
import com.example.core.ui.design.MainHeight.mainHeight60
import com.example.core.ui.design.MainWidth.largeWidth350
import com.example.core.ui.design.Modifiers.fillMaxSize

object TextFieldModifier {
    val tfMainModifier = Modifier
        .width(largeWidth350)
        .height(largeHeight80)
        .padding(horizontal = large20, vertical = medium12)
        .shadow(
            elevation = 0.dp,
            shape = roundedCornerShape20,
        )
}
@Composable
fun AuthTextField(
    text: String,
    onValueChange: (String) -> Unit,
    label: String
) {

    var textFieldText by remember { mutableStateOf(text) }

    val keyboardType = KeyboardType.Number

    TextField(
        value = textFieldText,
        onValueChange = {
            textFieldText = it
            onValueChange(it)
        },
        modifier = tfMainModifier,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        shape = roundedCornerShape20,
        colors = TextFieldDefaults.colors(
            disabledTextColor = colorTransparent,
            focusedContainerColor = inputFieldContainerColor,
            unfocusedContainerColor = inputFieldContainerColor,
            disabledContainerColor = inputFieldContainerColor,
            focusedIndicatorColor = mainTextColor,
            unfocusedIndicatorColor = colorTransparent,
            disabledIndicatorColor = colorTransparent,
        ),
        label = { Text(text = label) },
    )
}