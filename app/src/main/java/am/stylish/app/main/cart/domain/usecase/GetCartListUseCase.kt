package am.stylish.app.main.cart.domain.usecase

import am.stylish.app.common_domain.entity.CartItem
import am.stylish.app.main.cart.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow

interface GetCartListUseCase {
    fun invoke(): Flow<List<CartItem>>
}

class GetCartListUseCaseImpl(private val repository: CartRepository) : GetCartListUseCase {
    override fun invoke() = repository.getAllCartItems()
}