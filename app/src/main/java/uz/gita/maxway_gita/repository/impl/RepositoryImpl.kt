package uz.gita.maxway_gita.repository.impl

import android.content.Context
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.callbackFlow
import uz.gita.maxway_gita.data.MessageData
import uz.gita.maxway_gita.data.ResultData
import uz.gita.maxway_gita.data.firebase.Mapper.toAdsData
import uz.gita.maxway_gita.data.firebase.Mapper.toBranchData
import uz.gita.maxway_gita.data.firebase.Mapper.toCategoryData
import uz.gita.maxway_gita.data.firebase.Mapper.toOrderEntity
import uz.gita.maxway_gita.data.firebase.Mapper.toProductData
import uz.gita.maxway_gita.data.firebase.OrderEntity
import uz.gita.maxway_gita.data.local.*
import uz.gita.maxway_gita.data.prefs.MySharedPref
import uz.gita.maxway_gita.repository.Repository
import uz.gita.maxway_gita.utils.Constants
import uz.gita.maxway_gita.utils.extensions.hasConnection
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val sharedPref: MySharedPref
) : Repository {


    private val fireStore = Firebase.firestore


    override suspend fun loginClient(userData: UserData): ResultData<Boolean> {
        return if (context.hasConnection()) {
            fireStore.collection("clients").document(userData.id).set(userData)
            sharedPref.userId = userData.id
            ResultData.success(true)
        } else {
            ResultData.error(Throwable("No internet connection"))
        }
    }

    override fun getAllProductsWithCategory() = callbackFlow<ResultData<List<CategoryAndProduct>>> {
        if (context.hasConnection()) {
            val list = ArrayList<CategoryAndProduct>()
            fireStore.collection(Constants.CATEGORY)
                .get()
                .addOnSuccessListener {
                    it.documents.forEach { snapshot ->
                        val category = snapshot.toCategoryData()
                        list.add(category)
                        fireStore.collection(Constants.CATEGORY)
                            .document(snapshot.id)
                            .collection(Constants.FOODS)
                            .get().addOnSuccessListener { querySnapshot ->
                                list.addAll(querySnapshot.documents.map { it.toProductData() })
                            }
                    }
                    trySend(ResultData.success(list))
                }
        } else {
            trySend(ResultData.error(Throwable("No internet connection")))
        }
    }

    override fun searchProducts() = callbackFlow<ResultData<List<ProductData>>> {

    }

    override fun getAllCategories() = callbackFlow<ResultData<List<CategoryData>>> {
        if (context.hasConnection()) {
            fireStore.collection(Constants.CATEGORY)
                .get()
                .addOnSuccessListener { snapshot ->
                    trySend(ResultData.success(snapshot.documents.map { it.toCategoryData() }))
                }
        } else {
            trySend(ResultData.error(Throwable("No internet connection")))
        }
    }

    override fun getProductsByCategory(categoryId: String) =
        callbackFlow<ResultData<List<CategoryAndProduct>>> {
            if (context.hasConnection()) {
                fireStore.collection(Constants.CATEGORY)
                    .document(categoryId)
                    .collection(Constants.FOODS)
                    .get()
                    .addOnSuccessListener {
                        trySend(ResultData.success(it.documents.map { it.toProductData() }))
                    }
            } else {
                trySend(ResultData.error(Throwable("No internet connection")))
            }
        }

    override suspend fun insertOrder(orderEntity: OrderEntity): ResultData<Boolean> =
        if (context.hasConnection()) {
            fireStore.collection("clients").document(orderEntity.id).set(orderEntity)
            ResultData.success(true)
        } else {
            ResultData.error(Throwable("No internet connection"))
        }

    override fun getAllOrdersByClient() = callbackFlow {
        if (context.hasConnection()) {
            fireStore.collection("orders").whereEqualTo("clientId", sharedPref.userId)
                .get()
                .addOnSuccessListener { snapshot ->
                    trySend(snapshot.map { it.toOrderEntity() })
                }
        }
    }

    override fun getAllBranches() = callbackFlow<ResultData<List<BranchData>>> {
        if (context.hasConnection()) {
            fireStore.collection("branches")
                .get()
                .addOnSuccessListener { snapshot ->
                    trySend(ResultData.success(snapshot.map { it.toBranchData() }))
                }
        } else {
            ResultData.message<String>(MessageData.messageText("No internet connection"))
        }
    }

    override fun getAllAds() = callbackFlow<ResultData<List<AdsData>>> {
        if (context.hasConnection()) {
            fireStore.collection("ads")
                .get()
                .addOnSuccessListener { snapshot ->
                    trySend(ResultData.success(snapshot.map { it.toAdsData() }))
                }
        } else {
            ResultData.message<String>(MessageData.messageText("No internet connection"))
        }
    }

    override fun updateClient(userData: UserData): ResultData<Boolean> {
        return if (context.hasConnection()) {
            fireStore.collection("clients").document(userData.id).set(userData)
            sharedPref.userId = userData.id
            ResultData.success(true)
        } else {
            ResultData.error(Throwable("No internet connection"))
        }
    }
}