package am.stylish.app.main.wishlist.domain.usecase

import am.stylish.app.common_domain.entity.WishedItem
import am.stylish.app.common_domain.utils.Result
import am.stylish.app.main.wishlist.domain.repository.WishedListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface DeleteWishedItemUseCase {
    fun invoke(item: WishedItem): Flow<Result>
}

class DeleteWishedItemUseCaseImpl(private val repository: WishedListRepository) : DeleteWishedItemUseCase {
    override fun invoke(item: WishedItem) = flow { emit(repository.delete(item)) }
}