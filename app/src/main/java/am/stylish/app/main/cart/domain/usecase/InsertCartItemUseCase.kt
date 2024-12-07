package am.stylish.app.main.cart.domain.usecase

import am.stylish.app.common_domain.entity.CartItem
import am.stylish.app.common_domain.entity.WishedItem
import am.stylish.app.common_domain.utils.Result
import am.stylish.app.main.cart.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface InsertCartItemUseCase {
    fun invoke(item: CartItem): Flow<Result>
}

class InsertCartItemUseCaseImpl(private val repository: CartRepository) : InsertCartItemUseCase {
    override fun invoke(item: CartItem) = flow { emit(repository.insert(item)) }
}