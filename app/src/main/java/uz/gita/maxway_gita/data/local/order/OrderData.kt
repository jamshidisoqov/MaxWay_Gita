package uz.gita.maxway_gita.data.local.order

data class OrderData(
    val id:Int,
    val orderNumber:Int,
    val orderMessage:String,
    val status:Int//1 -> buyurtma qabul qiln\indi  2 -> buyurtma filialda qabul qilinidi  3 -> tayyor
)