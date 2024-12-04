package am.stylish.app.common_data.repository

import am.stylish.app.common_domain.model.product.PageProduct
import am.stylish.app.common_domain.repository.ProductsRepository
import am.stylish.app.common_presentation.utils.test_mock_data.mockPageProductData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ProductsRepositoryImpl : ProductsRepository {
    override fun getPageProducts(): Flow<List<PageProduct>> = flowOf(mockPageProductData)
}