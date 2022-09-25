package uz.gita.maxway_gita.presentation.screens.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.gita.maxway_gita.presentation.screens.history.item.HistoryItem
import uz.gita.maxway_gita.presentation.theme.MaxWayGitaTheme

class HistoryOrderPager : AndroidScreen() {

    @Composable
    override fun Content() {
        MaxWayGitaTheme {
            HistoryOrderPagerContent()
        }
    }
}

@Composable
fun HistoryOrderPagerContent() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.background(color = Color(0xFFF2EDF7))) {
            Text(
                text = "Previous months",
                fontSize = 24.sp,
                modifier = Modifier.padding(15.dp),
                fontWeight = FontWeight.SemiBold
            )

            LazyColumn {
                items(5) {
                    HistoryItem(
                        orderNumber = "Order No.123",
                        orderPrice = "23 000",
                        orderDate = "24.09.2022"
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun HistoryOrderPagerPreview() {
    MaxWayGitaTheme {
        HistoryOrderPagerContent()
    }
}