package uz.gita.maxway_gita.presentation.screens.order.checkout.ui_state

// Yusupov Bekzod
data class CheckoutUiState(
    val selfPickUp: Boolean = false,
    val delivery: Boolean = false,
    val comment: String? = null,
    val deliveryAddress: String? = null,

    val sumOfGoods: String? = null,
    val goodsList: Map<String, Int>? = mapOf(),
    val totalAmount: String? = null,
)
