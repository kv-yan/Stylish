package am.stylish.app.main.cart.data.repository

import am.stylish.app.common_data.dao.CartDao
import am.stylish.app.common_domain.entity.CartItem
import am.stylish.app.common_domain.utils.Result
import am.stylish.app.main.cart.domain.repository.CartRepository

class CartRepositoryImpl(private val dao: CartDao) : CartRepository {

    override suspend fun insert(item: CartItem) = Result.Success(dao.insert(item))

    override suspend fun delete(item: CartItem) = Result.Success(dao.delete(item))

    override suspend fun update(item: CartItem) = Result.Success(dao.update(item))

    override fun getAllCartItems() = dao.getAllWishedItems()
}
