package uz.gita.maxway_gita.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.BackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.gita.maxway_gita.R

@Composable
fun AppBar(
    title:String
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)) {
        Row(modifier = Modifier.fillMaxSize()) {
            Image(painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_24), modifier = Modifier.fillMaxHeight(), contentDescription = "back")
        }
    }
}

@Composable
@Preview
fun AppbarPre() {
    AppBar("hello")
}