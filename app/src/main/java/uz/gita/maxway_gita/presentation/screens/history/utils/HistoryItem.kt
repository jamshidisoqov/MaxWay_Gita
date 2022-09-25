package uz.gita.maxway_gita.presentation.screens.history.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.gita.maxway_gita.R
import uz.gita.maxway_gita.presentation.theme.MaxWayGitaTheme

@Composable
fun HistoryItem(
    orderNumber: String,
    orderPrice: String,
    orderDate: String
) {
    MaxWayGitaTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 5.dp),
            shape = RoundedCornerShape(10)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .padding(15.dp)
                        .weight(9f)
                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 3.dp),
                        text = orderNumber,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        modifier = Modifier.padding(bottom = 3.dp),
                        text = orderPrice,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = orderDate,
                        fontSize = 18.sp,
                        color = Color(0xFF818C99)
                    )
                }
                Column(modifier = Modifier.weight(1f)) {
                    Icon(
                        tint = Color(0xFF818C99),
                        painter = painterResource(id = R.drawable.delete),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun HistoryItemPreview() {
    HistoryItem("Order No.1342", "109 540 sum", "12.03.2021")
}