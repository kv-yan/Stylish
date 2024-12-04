package am.stylish.app.main.home.domain.usecase

import am.stylish.app.common_domain.model.product.PageProduct
import am.stylish.app.common_domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow

interface GetHomePageProductsUseCase {
    fun invoke(): Flow<List<PageProduct>>
}

class GetHomePageProductsUseCaseImpl(
    private val productsRepository: ProductsRepository
) : GetHomePageProductsUseCase {
    override fun invoke(): Flow<List<PageProduct>> {
        return productsRepository.getPageProducts()
    }

}