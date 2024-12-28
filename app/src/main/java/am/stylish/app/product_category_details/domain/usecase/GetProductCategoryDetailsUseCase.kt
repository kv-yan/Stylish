package am.stylish.app.product_category_details.domain.usecase

import am.stylish.app.common_presentation.utils.test_mock_data.mockProductCategories
import am.stylish.app.main.search.domain.model.ProductCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface GetProductCategoryDetailsUseCase {
    fun invoke(categoryId: String): Flow<Result<ProductCategory?>>
}

class GetProductCategoryDetailsUseCaseImpl : GetProductCategoryDetailsUseCase {
    override fun invoke(categoryId: String): Flow<Result<ProductCategory?>> = flow {
        val specialOffer = mockProductCategories.find { it.id == categoryId }

        emit(Result.success(specialOffer))
    }
}