package am.stylish.app.main.wishlist.domain.usecase

import am.stylish.app.common_domain.entity.WishedItem
import am.stylish.app.common_domain.utils.Result
import am.stylish.app.main.wishlist.domain.repository.WishedListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface InsertWishedItemUseCase {
    fun invoke(item: WishedItem): Flow<Result>
}

class InsertWishedItemUseCaseImpl(private val repository: WishedListRepository) : InsertWishedItemUseCase {
    override fun invoke(item: WishedItem) = flow { emit(repository.insert(item)) }
}