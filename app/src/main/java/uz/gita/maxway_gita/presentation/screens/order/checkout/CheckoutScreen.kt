package uz.gita.maxway_gita.presentation.screens.order.checkout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import uz.gita.maxway_gita.R
import uz.gita.maxway_gita.presentation.screens.order.checkout.intent.CheckoutIntent
import uz.gita.maxway_gita.presentation.screens.order.checkout.ui_state.CheckoutUiState
import uz.gita.maxway_gita.presentation.screens.order.checkout.viewmodels.CheckoutViewModel
import uz.gita.maxway_gita.presentation.screens.order.checkout.viewmodels.impl.CheckoutViewModelImpl
import uz.gita.maxway_gita.utils.AppBar

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
    Surface(modifier = Modifier.fillMaxSize().background(Color(0xFFF8F6FA))) {
        AppBar(onEventDispatcher = eventDispatcher)//title ham bersa bo'ladi man default yozib qo'ygganim uchun bu yerda so'ramadi.
    }
}