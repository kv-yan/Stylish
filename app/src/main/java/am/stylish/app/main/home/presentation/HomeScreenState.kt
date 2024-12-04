package am.stylish.app.main.home.presentation

import am.stylish.app.common_domain.model.product.PageProduct

sealed class HomeScreenState {
    data object Loading : HomeScreenState()

    data class Error(val message: Int) : HomeScreenState()

    data class Success(
        val pageProduct: List<PageProduct>,
        val isWishlistAdded: Boolean = false
    ) : HomeScreenState()
}