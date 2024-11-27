package am.stylish.app.product_details.presentation

import am.stylish.app.common_domain.model.details.ProductDetails

sealed class DetailsScreenState {
    data object Loading : DetailsScreenState()
    data class Success(val productDetails: ProductDetails) : DetailsScreenState()
    data class Error(val message: Int) : DetailsScreenState()
}