package uz.gita.maxway_gita.presentation.screens.basket

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.gita.maxway_gita.presentation.theme.MaxWayGitaTheme

// Created by Jamshid Isoqov an 9/24/2022
class BasketScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        MaxWayGitaTheme {
            BasketScreenContent()
        }
    }
}

@Composable
fun BasketScreenContent() {

}

@Composable
@Preview
fun BasketScreenPreview() {
    MaxWayGitaTheme {
        BasketScreenContent()
    }
}