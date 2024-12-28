package am.stylish.app.main.search.domain.usecase

import am.stylish.app.common_domain.utils.Result
import am.stylish.app.common_presentation.utils.test_mock_data.mockProductCategories
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface GetProductCategoriesUseCase {
    fun invoke(): Flow<Result>
}

class GetProductCategoriesUseCaseImpl(
) : GetProductCategoriesUseCase {
    override fun invoke() = flowOf(Result.Success(mockProductCategories))
}