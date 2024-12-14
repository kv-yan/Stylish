package am.stylish.app.order_details_screen.presentation

import am.stylish.app.common_presentation.utils.test_mock_data.mockProductsData
import am.stylish.app.order_details_screen.domain.model.OrderItem
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class OrderDetailsViewModel(private val productsIdList: List<String>) : ViewModel() {

    private val _orderItemsList = MutableStateFlow<List<OrderItem>>(emptyList())
    val orderItemsList: StateFlow<List<OrderItem>> = _orderItemsList.asStateFlow()

    private val _screenState =
        MutableStateFlow<OrderDetailsScreenState>(OrderDetailsScreenState.Loading)
    val screenState: StateFlow<OrderDetailsScreenState> = _screenState.asStateFlow()

    private val _totalPrice = MutableStateFlow(0)
    val totalPrice: StateFlow<Int> = _totalPrice.asStateFlow()


    init {
        getOrderItems()
    }

    private fun getOrderItems() {
        viewModelScope.launch(Dispatchers.IO) {
            val orderItems = mutableListOf<OrderItem>()
            productsIdList.forEach { productId ->
                val product = mockProductsData.find { it.id == productId }
                if (product != null) {
                    orderItems.add(
                        OrderItem(
                            isSelected = true,
                            product = product,
                            quantity = 1,
                            color = "Black",
                            size = "8 UK"
                        )
                    )
                }
            }
            if (orderItems.isEmpty()) {
                _screenState.value = OrderDetailsScreenState.Error("No order items found")
            } else {
                _orderItemsList.value = orderItems
                _screenState.value = OrderDetailsScreenState.Success(orderItems)
            }
        }
    }

    fun updateOrderItem(orderItem: OrderItem) {
        viewModelScope.launch(Dispatchers.IO) {
            val updatedList = _orderItemsList.value.map { item ->
                if (item.id == orderItem.id) item.copy(isSelected = orderItem.isSelected) else item
            }
            _orderItemsList.value = updatedList
            calculateTotalPrice()
        }
    }

    fun removeOrderItem(orderItem: OrderItem) {
        viewModelScope.launch(Dispatchers.IO) {
            val orderItems = _orderItemsList.value.toMutableList()
            orderItems.remove(orderItem)
            _orderItemsList.value = orderItems
        }
    }

    fun calculateTotalPrice() {
        val total = _orderItemsList.value
            .filter { it.isSelected }
            .sumOf { it.product.price * it.quantity }
        _totalPrice.value = total
    }
}
