package am.stylish.app.order_details_screen.presentation

import am.stylish.app.order_details_screen.domain.model.OrderItem

sealed class OrderDetailsScreenState {
    data object Loading : OrderDetailsScreenState()
    data class Error(val message: String) : OrderDetailsScreenState()
    data class Success(val orderItems: List<OrderItem>) : OrderDetailsScreenState()

}