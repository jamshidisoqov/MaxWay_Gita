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

    fun DocumentSnapshot.toaCategoryData() = CategoryData(
        id = this.id,
        name = this["name"].toString()
    )
}

