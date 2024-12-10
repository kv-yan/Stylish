package am.stylish.app.main.cart.presentation

import am.stylish.app.common_domain.model.product.Product

sealed class CartScreenState {
    data object Loading : CartScreenState()
    data class Success(val cartItems: List<Product>) : CartScreenState()
    data class Error(val message: String) : CartScreenState()

}