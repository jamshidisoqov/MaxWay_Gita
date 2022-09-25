package uz.gita.maxway_gita.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.gita.maxway_gita.R
import uz.gita.maxway_gita.presentation.screens.order.checkout.intent.CheckoutIntent

@Composable
fun AppBar(
    title: String = "Checkout Order",
    onEventDispatcher:(CheckoutIntent)->Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.White),
    ) {
        Image(
            contentDescription = "back",
            painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_24),
            modifier = Modifier
                .clickable { onEventDispatcher(CheckoutIntent.back) }
                .padding(18.dp),
        )
        Text(text = title, modifier = Modifier.align(Alignment.Center), style = TextStyle(fontSize = 17.sp, fontWeight = FontWeight.SemiBold))
    }
}

@Composable
@Preview
fun AppbarPre() {
//    AppBar()
}