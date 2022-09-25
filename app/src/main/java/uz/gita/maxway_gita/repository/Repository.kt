package uz.gita.maxway_gita.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.maxway_gita.data.ResultData
import uz.gita.maxway_gita.data.firebase.OrderEntity
import uz.gita.maxway_gita.data.local.*

// Created by Jamshid Isoqov an 9/25/2022
interface Repository {


    suspend fun loginClient(userData: UserData): ResultData<Boolean>

    fun getAllProductsWithCategory(): Flow<ResultData<List<CategoryAndProduct>>>

    fun searchProducts(): Flow<ResultData<List<ProductData>>>

    fun getAllCategories(): Flow<ResultData<List<CategoryData>>>

    fun getProductsByCategory(categoryId: String): Flow<ResultData<List<CategoryAndProduct>>>

    suspend fun insertOrder(orderEntity: OrderEntity): ResultData<Boolean>

    fun getAllOrdersByClient(): Flow<List<OrderEntity>>

    fun getAllBranches(): Flow<ResultData<List<BranchData>>>

    fun getAllAds(): Flow<ResultData<List<AdsData>>>

    fun updateClient(userData: UserData): ResultData<Boolean>


}