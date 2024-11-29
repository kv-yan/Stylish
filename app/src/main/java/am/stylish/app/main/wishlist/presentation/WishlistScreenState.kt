package am.stylish.app.main.wishlist.presentation

import am.stylish.app.common_domain.model.product.Product

sealed class WishlistScreenState {
    data object Loading : WishlistScreenState()
    data class Success(val wishlistItems: List<Product>) : WishlistScreenState()
    data class Error(val message: String) : WishlistScreenState()

}