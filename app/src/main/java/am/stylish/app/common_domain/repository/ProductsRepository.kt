package am.stylish.app.common_domain.repository

import am.stylish.app.common_domain.model.product.PageProduct
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    fun getPageProducts(): Flow<List<PageProduct>>
}