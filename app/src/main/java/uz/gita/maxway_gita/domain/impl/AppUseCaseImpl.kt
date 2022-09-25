package uz.gita.maxway_gita.domain.impl

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collectLatest
import uz.gita.maxway_gita.data.MessageData
import uz.gita.maxway_gita.data.ResultData
import uz.gita.maxway_gita.data.local.*
import uz.gita.maxway_gita.data.local.order.OrderData
import uz.gita.maxway_gita.domain.AppUseCase
import uz.gita.maxway_gita.repository.Repository
import uz.gita.maxway_gita.utils.extensions.hasConnection
import javax.inject.Inject

class AppUseCaseImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: Repository
) : AppUseCase {
    override suspend fun loginClient(userData: UserData): ResultData<Boolean> =
        repository.loginClient(userData)

    override fun getAllProductsWithCategory(): Flow<ResultData<List<CategoryAndProduct>>> =
        repository.getAllProductsWithCategory()

    override fun searchProducts(): Flow<ResultData<List<ProductData>>> = repository.searchProducts()

    override fun getAllCategories(): Flow<ResultData<List<CategoryData>>> =
        repository.getAllCategories()

    override fun getProductsByCategory(categoryId: String): Flow<ResultData<List<CategoryAndProduct>>> =
        repository.getProductsByCategory(categoryId)

    override suspend fun insertOrder(orderData: OrderData): ResultData<Boolean> =
        repository.insertOrder(orderData.toOrderEntity())

    override fun getAllOrdersByClient() = callbackFlow<ResultData<List<OrderData>>> {
        if (context.hasConnection()) {
            repository.getAllOrdersByClient().collectLatest {
                trySend(ResultData.success(it.map { it.toOrderData() }))
            }
        } else {
            trySend(ResultData.message(MessageData.messageText("No internet connection")))
        }
    }


    override fun getAllBranches(): Flow<ResultData<List<BranchData>>> =
        repository.getAllBranches()

    override fun getAllAds(): Flow<ResultData<List<AdsData>>> =
        repository.getAllAds()

    override fun updateClient(userData: UserData): ResultData<Boolean> =
        repository.updateClient(userData)
}