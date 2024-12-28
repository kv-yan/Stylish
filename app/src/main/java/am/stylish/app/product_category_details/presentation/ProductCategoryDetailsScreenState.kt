package am.stylish.app.product_category_details.presentation

import am.stylish.app.main.search.domain.model.ProductCategory

sealed class ProductCategoryDetailsScreenState {
    data object Loading : ProductCategoryDetailsScreenState()
    data class Error(val message: String) : ProductCategoryDetailsScreenState()
    data class Success(val specialOffer: ProductCategory) : ProductCategoryDetailsScreenState()
}