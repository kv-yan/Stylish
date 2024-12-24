package am.stylish.app.checkout.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CheckoutViewModel(totalPrice: Int) : ViewModel() {
    private val _totalPrice = MutableStateFlow<Int?>(null)
    val totalPrice = _totalPrice.asStateFlow()

    private val _shippingPrice = MutableStateFlow<Int?>(30)
    val shippingPrice = _shippingPrice.asStateFlow()

    init {
        _totalPrice.value = totalPrice
    }
}