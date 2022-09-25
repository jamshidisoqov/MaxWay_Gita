package uz.gita.maxway_gita.presentation.screens.order.checkout.intent


// Yusupov Bekzod
sealed interface CheckoutIntent {
    object deliveryMethod : CheckoutIntent
    object DeliveryAddress : CheckoutIntent
    class CheckoutOrder(orderId: Int) : CheckoutIntent
    object back : CheckoutIntent
}