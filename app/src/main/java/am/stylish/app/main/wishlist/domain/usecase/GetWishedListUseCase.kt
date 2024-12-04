package am.stylish.app.main.wishlist.domain.usecase

import am.stylish.app.common_domain.entity.WishedItem
import am.stylish.app.main.wishlist.domain.repository.WishedListRepository
import kotlinx.coroutines.flow.Flow

interface GetWishedListUseCase {
    fun invoke(): Flow<List<WishedItem>>
}

class GetWishedListUseCaseImpl(private val repository: WishedListRepository) : GetWishedListUseCase {
    override fun invoke(): Flow<List<WishedItem>> = repository.getAllWishedItems()
}