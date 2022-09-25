package uz.gita.maxway_gita.data.local

import com.google.firebase.firestore.GeoPoint

// Created by Jamshid Isoqov an 9/24/2022
data class BranchData(
    val address:String,
    val geoPoint: GeoPoint,
    val imageUrl:String,
    val name:String,
    val phone:String,
    val schedule:String,
    val target:String
)
