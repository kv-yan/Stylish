package am.stylish.app.main.wishlist.data.repository

import am.stylish.app.common_data.dao.WishlistDao
import am.stylish.app.common_domain.entity.WishedItem
import am.stylish.app.main.wishlist.domain.repository.WishedListRepository
import kotlinx.coroutines.flow.Flow
import am.stylish.app.common_domain.utils.Result

class WishedListRepositoryImpl(private val wishlistDao: WishlistDao) : WishedListRepository {

    override suspend fun insert(item: WishedItem) = Result.Success(wishlistDao.insert(item))

    override suspend fun update(item: WishedItem) = Result.Success(wishlistDao.update(item))

    override suspend fun delete(item: WishedItem) = Result.Success(wishlistDao.delete(item))

    override suspend fun deleteAll() = Result.Success(wishlistDao.deleteAll())

    override fun getAllWishedItems(): Flow<List<WishedItem>> = wishlistDao.getAllWishedItems()
}
