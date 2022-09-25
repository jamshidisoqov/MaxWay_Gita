package uz.gita.maxway_gita.data.firebase

import com.google.firebase.firestore.GeoPoint
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.gita.maxway_gita.data.local.order.OrderData
import uz.gita.maxway_gita.data.local.order.ProductOrder

// Created by Jamshid Isoqov an 9/25/2022
data class OrderEntity(
    val id: String,
    val productOrder: String,
    val orderName: String,
    val allOrderValue: Long,
    val isDelivery: Boolean,
    val clientId: String,
    val status: Int = 1,
    val address: GeoPoint? = null,
    val comment: String? = null,
) {
    fun toOrderData(): OrderData {
        val gson = Gson()
        val type = object : TypeToken<List<ProductOrder>>() {}.type
        val order = gson.fromJson<List<ProductOrder>>(productOrder, type)
        return OrderData(
            id = id,
            productOrder = order,
            orderName = orderName,
            allOrderValue = allOrderValue,
            isDelivery = isDelivery,
            status = status,
            address = address,
            comment = comment,
            clientId = clientId
        )
    }
}
