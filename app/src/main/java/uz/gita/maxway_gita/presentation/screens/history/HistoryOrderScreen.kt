package uz.gita.maxway_gita.presentation.screens.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import uz.gita.maxway_gita.presentation.screens.basket.BasketScreen
import uz.gita.maxway_gita.presentation.screens.basket.BasketScreenContent
import uz.gita.maxway_gita.presentation.theme.MaxWayGitaTheme

// Created by Jamshid Isoqov an 9/24/2022
class HistoryOrderScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        MaxWayGitaTheme {
            HistoryOrderScreenContent()
        }
    }
}

@Composable
fun HistoryOrderScreenContent() {
    Surface {
        Column {
            Text(text = "Mening zaqaslarim")
            TabLayout()
        }
    }
}

@Composable
fun TabLayout() {
    var selectedIndex by remember { mutableStateOf(0) }
    val list = listOf("Hozirgi zaqaslar", "Zaqaslar tarixi")

    TabRow(selectedTabIndex = selectedIndex,
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clip(RoundedCornerShape(30)),
        backgroundColor = Color(0xFFA8A8A8),
        indicator = { tabPositions: List<TabPosition> ->
            Box {}
        }
    ) {
        list.forEachIndexed { index, text ->
            val selected = selectedIndex == index
            Tab(
                modifier = if (selected) Modifier
                    .padding(3.dp)
                    .clip(RoundedCornerShape(30))
                    .background(Color.White)
                else Modifier
                    .clip(RoundedCornerShape(30))
                    .background(Color(0xFFA8A8A8))
                    .padding(3.dp),
                selected = selected,
                onClick = { selectedIndex = index },
                text = { Text(text = text, color = Color(0xff000000)) }
            )
        }
    }
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
fun HistoryOrderScreenPreview() {
    MaxWayGitaTheme {
        HistoryOrderScreenContent()
    }
}