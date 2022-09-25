package uz.gita.maxway_gita.data.local.order

import com.google.firebase.firestore.GeoPoint
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.gita.maxway_gita.data.firebase.OrderEntity
import java.util.*

data class OrderData(
    val id: String = UUID.randomUUID().toString(),
    val productOrder: List<ProductOrder>,
    val orderName: String,
    val allOrderValue: Long,
    val isDelivery: Boolean,
    val status: Int = 1,
    val address: GeoPoint? = null,
    val comment: String? = null,
    val clientId: String
) {
    fun toOrderEntity(): OrderEntity {
        val gson = Gson()
        val type = object : TypeToken<List<ProductOrder>>() {}.type
        val order = gson.toJson(productOrder, type)
        return OrderEntity(
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