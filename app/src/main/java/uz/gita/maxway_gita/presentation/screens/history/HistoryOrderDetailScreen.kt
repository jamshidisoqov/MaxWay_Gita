package uz.gita.maxway_gita.presentation.screens.history

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.gita.maxway_gita.presentation.theme.MaxWayGitaTheme

class HistoryOrderDetailScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        MaxWayGitaTheme {
            HistoryOrderDetailScreenContent()
        }
    }
}

@Composable
fun HistoryOrderDetailScreenContent() {

}

@Composable
@Preview
fun HistoryOrderDetailScreenPreview() {
    MaxWayGitaTheme {
        HistoryOrderDetailScreenContent()
    }
}