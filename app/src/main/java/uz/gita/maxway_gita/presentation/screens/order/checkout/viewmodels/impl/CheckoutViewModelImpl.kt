package uz.gita.maxway_gita.presentation.screens.order.checkout.viewmodels.impl

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.maxway_gita.presentation.screens.order.checkout.intent.CheckoutIntent
import uz.gita.maxway_gita.presentation.screens.order.checkout.ui_state.CheckoutUiState
import uz.gita.maxway_gita.presentation.screens.order.checkout.viewmodels.CheckoutViewModel
import javax.inject.Inject

//Yusupov Bekzod
@HiltViewModel
class CheckoutViewModelImpl @Inject constructor() : CheckoutViewModel, ViewModel() {
    override val container: Container<CheckoutUiState, Nothing> = container(CheckoutUiState())

    override fun onEventDispatcher(intent: CheckoutIntent) = intent {
//        when (intent) {
//            is CheckoutIntent.deliveryMethod -> reduce { /*logic from useCase!*/ }
//            is CheckoutIntent.DeliveryAddress -> reduce { }
//            is CheckoutIntent.CheckoutOrder -> reduce { }
//            is CheckoutIntent.back -> direction.navigateToSecond()
//        }
    }
}