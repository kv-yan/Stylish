package am.stylish.app.main.cart.domain.usecase

import am.stylish.app.common_domain.entity.CartItem
import am.stylish.app.common_domain.entity.WishedItem
import am.stylish.app.common_domain.utils.Result
import am.stylish.app.main.cart.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface UpdateCartItemUseCase {
    fun invoke(item: CartItem): Flow<Result>
}

class UpdateCartItemUseCaseImpl(private val repository: CartRepository) : UpdateCartItemUseCase {
    override fun invoke(item: CartItem) = flow { emit(repository.insert(item)) }
}