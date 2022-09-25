package uz.gita.maxway_gita.data.local

import java.util.*

// Created by Jamshid Isoqov an 9/25/2022
data class UserData(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val phone: String,
    val birthday: String? = null
)
