package uz.gita.maxway_gita.data.local

// Created by Jamshid Isoqov an 9/24/2022
data class ProductData(
    val id:String,
    val name: String,
    val imageUrl: String,
    val price: Long,
    val info: String
):CategoryAndProduct
