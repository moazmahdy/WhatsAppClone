package com.example.auth.ui.mainauth.componant

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.example.auth.ui.mainauth.componant.ButtonModifier.bMainModifier
import com.example.core.ui.design.Borders
import com.example.core.ui.design.Colors.mainTextColor
import com.example.core.ui.design.Dimens
import com.example.core.ui.design.MainHeight
import com.example.core.ui.design.MainWidth

object ButtonModifier {
    val bMainModifier = Modifier
        .width(MainWidth.largeWidth350)
        .height(MainHeight.largeHeight80)
        .padding(horizontal = Dimens.large20, vertical = Dimens.medium12)
        .shadow(
            elevation = 0.dp,
            shape = Borders.roundedCornerShape20,
        )
}

@Composable
fun AuthButton(onClick:()-> Unit) {

    Button(
        onClick = { onClick() },
        modifier = bMainModifier
        ) {
        Text(
            text = "Send Code",
            color = mainTextColor
        )
    }
}