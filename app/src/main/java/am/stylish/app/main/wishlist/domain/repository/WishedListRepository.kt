package am.stylish.app.main.wishlist.domain.repository

import am.stylish.app.common_domain.entity.WishedItem
import am.stylish.app.common_domain.utils.Result
import kotlinx.coroutines.flow.Flow

interface WishedListRepository {
    suspend fun insert(item: WishedItem): Result
    suspend fun update(item: WishedItem): Result
    suspend fun delete(item: WishedItem): Result
    suspend fun deleteAll(): Result
    fun getAllWishedItems(): Flow<List<WishedItem>>
}