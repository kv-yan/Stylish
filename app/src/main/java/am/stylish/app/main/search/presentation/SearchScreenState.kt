package am.stylish.app.main.search.presentation

import am.stylish.app.main.search.domain.model.ProductCategory

sealed class SearchScreenState {
    data object Loading : SearchScreenState()
    data class Success(val products: List<ProductCategory>) : SearchScreenState()
    data class Error(val message: String) : SearchScreenState()


}