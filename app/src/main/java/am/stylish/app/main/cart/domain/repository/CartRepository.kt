package am.stylish.app.main.cart.domain.repository

import am.stylish.app.common_domain.entity.CartItem
import am.stylish.app.common_domain.utils.Result
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    suspend fun insert(item: CartItem): Result
    suspend fun delete(item: CartItem): Result
    suspend fun update(item: CartItem): Result
    fun getAllCartItems(): Flow<List<CartItem>>
}