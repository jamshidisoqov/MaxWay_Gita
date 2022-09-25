package uz.gita.maxway_gita.presentation.screens.order.checkout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import uz.gita.maxway_gita.presentation.screens.order.checkout.intent.CheckoutIntent
import uz.gita.maxway_gita.presentation.screens.order.checkout.ui_state.CheckoutUiState
import uz.gita.maxway_gita.presentation.screens.order.checkout.viewmodels.CheckoutViewModel
import uz.gita.maxway_gita.presentation.screens.order.checkout.viewmodels.impl.CheckoutViewModelImpl

// Yusupov Bekzod.
class CheckoutScreen: AndroidScreen() {

    @Composable
    override fun Content() {
        val viewModel:CheckoutViewModel = getViewModel<CheckoutViewModelImpl>()
        val uiState = viewModel.collectAsState().value
        MainScreenContent(uiState = uiState, eventDispatcher = viewModel::onEventDispatcher)
    }
}

@Composable
private fun MainScreenContent(
    uiState: CheckoutUiState,
    eventDispatcher: (CheckoutIntent) -> Unit
) {
    Surface(modifier = Modifier.fillMaxSize()) {

    }
}