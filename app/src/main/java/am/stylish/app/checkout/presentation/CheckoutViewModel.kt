package am.stylish.app.checkout.presentation

import am.stylish.app.common_presentation.components.dialog.DialogState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CheckoutViewModel(totalPrice: Int) : ViewModel() {
    private val _totalPrice = MutableStateFlow<Int?>(null)
    val totalPrice = _totalPrice.asStateFlow()

    private val _shippingPrice = MutableStateFlow<Int?>(30)
    val shippingPrice = _shippingPrice.asStateFlow()

    private val _showingPaymentResultDialog = MutableStateFlow<Boolean>(false)
    val showingPaymentResultDialog = _showingPaymentResultDialog.asStateFlow()

    private val _paymentDialogState = MutableStateFlow<DialogState>(DialogState.Loading)
    val paymentDialogState = _paymentDialogState.asStateFlow()


    fun hidePaymentResultDialog() {
        _showingPaymentResultDialog.value = false
        _paymentDialogState.value = DialogState.Loading
    }

    fun showPaymentResultDialog() {
        viewModelScope.launch(Dispatchers.IO) {
            _showingPaymentResultDialog.value = true
            _paymentDialogState.value = DialogState.Loading
            delay(2000)
            _paymentDialogState.value = DialogState.Success("Payment Done Successful")
        }
    }

    init {
        _totalPrice.value = totalPrice
    }
}