package uz.gita.maxway_gita.data.firebase

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.GeoPoint
import uz.gita.maxway_gita.data.local.AdsData
import uz.gita.maxway_gita.data.local.BranchData
import uz.gita.maxway_gita.data.local.CategoryData
import uz.gita.maxway_gita.data.local.ProductData

object Mapper {
    fun DocumentSnapshot.toAdsData() = AdsData(
        id = this.id,
        name = this["name"].toString(),
        info = this["info"].toString(),
        imgUrl = this["img_url"].toString()
    )

    fun DocumentSnapshot.toBranchData() = BranchData(
        name = this["name"].toString(),
        phone = this["info"].toString(),
        target = this["target"].toString(),
        schedule = this["schedule"].toString(),
        address = this["address"].toString(),
        geoPoint = (this["geo"] as GeoPoint),
        imageUrl = this["img_url"].toString()
    )

    fun DocumentSnapshot.toProductData() = ProductData(
        id = this.id,
        name = this["name"].toString(),
        info = this["info"].toString(),
        price = this["price"].toString().toLong(),
        imageUrl = this["img_url"].toString()
    )

    fun DocumentSnapshot.toCategoryData() = CategoryData(
        id = this.id,
        name = this["name"].toString()
    )

    fun DocumentSnapshot.toOrderEntity() = OrderEntity(
        id = this.id,
        productOrder = this["productOrder"].toString(),
        orderName = this["orderName"].toString(),
        allOrderValue = this["allOrderValue"].toString().toLong(),
        isDelivery = this["isDelivery"].toString().toBoolean(),
        clientId = this["clientId"].toString(),
        status = this["status"].toString().toInt(),
        address = this["address"] as GeoPoint,
        comment = this["comment"].toString()
    )
}

