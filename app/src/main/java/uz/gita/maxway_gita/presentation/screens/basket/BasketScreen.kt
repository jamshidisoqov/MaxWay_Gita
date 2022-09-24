package uz.gita.maxway_gita.presentation.screens.basket

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.androidx.AndroidScreen
import com.google.accompanist.pager.*
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
    Surface {
        Column {
            Text(text = "Mening zaqaslarim")
            TabLayout()
        }
    }
}

@Composable
fun TabLayout() {

}

@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState) {
    HorizontalPager(state = pagerState) { page ->
        when (page) {
            0 -> BasketScreen()
            1 -> BasketScreen()
            2 -> BasketScreen()
        }
    }
}

@Composable
@Preview
fun BasketScreenPreview() {
    MaxWayGitaTheme {
        BasketScreenContent()
    }
}