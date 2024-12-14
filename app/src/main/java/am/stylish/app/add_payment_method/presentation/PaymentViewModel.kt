package am.stylish.app.add_payment_method.presentation

import am.stylish.app.R
import am.stylish.app.add_payment_method.domain.model.PaymentMethod
import am.stylish.app.add_payment_method.domain.model.PaymentMethodType
import am.stylish.app.add_payment_method.domain.usecase.AddPaymentMethodUseCase
import am.stylish.app.add_payment_method.domain.usecase.GetPaymentMethodsUseCase
import am.stylish.app.common_domain.utils.Result
import am.stylish.app.common_presentation.components.snackbars.SnackbarState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class PaymentViewModel(
    private val addPaymentMethodUseCase: AddPaymentMethodUseCase,
    getPaymentMethodsUseCase: GetPaymentMethodsUseCase
) : ViewModel() {
    private val _paymentMethods = MutableStateFlow<List<PaymentMethod>>(emptyList())
    val paymentMethods: StateFlow<List<PaymentMethod>> = _paymentMethods.asStateFlow()

    private val _cardNumber = MutableStateFlow("")
    val cardNumber = _cardNumber.asStateFlow()

    private val _cardHolderName = MutableStateFlow("")
    val cardHolderName = _cardHolderName.asStateFlow()

    private val _expiryDate = MutableStateFlow("")
    val expiryDate = _expiryDate.asStateFlow()

    private val _securityCode = MutableStateFlow("")
    val securityCode = MutableStateFlow("")

    private val _selectedPaymentMethod = MutableStateFlow<PaymentMethod?>(null)
    val selectedPaymentMethod = _selectedPaymentMethod.asStateFlow()

    fun setCardNumber(number: String) = _cardNumber.tryEmit(number)

    fun setCardHolderName(name: String) = _cardHolderName.tryEmit(name)

    fun setExpiryDate(date: String) = _expiryDate.tryEmit(date)

    fun setSecurityCode(code: String) = _securityCode.tryEmit(code)

    fun setPaymentMethod(paymentMethod: PaymentMethod) = _selectedPaymentMethod.tryEmit(paymentMethod)


    init {
        getPaymentMethodsUseCase.invoke().onEach {
            _paymentMethods.value = it
            _selectedPaymentMethod.value = it.firstOrNull()
        }.launchIn(viewModelScope)
    }

    fun addPaymentMethod(data: String, onSuccess: (SnackbarState) -> Unit) {
        val type = inferPaymentType(data)
        val paymentMethod = PaymentMethod(value = data, type = type)
        println(paymentMethod)
        addPaymentMethodUseCase.invoke(paymentMethod).onEach {
            onSuccess(
                when (it) {
                    is Result.Error<*> -> SnackbarState.Error(R.string.failed_to_add_payment_method)

                    is Result.Success<*> -> SnackbarState.Success(R.string.payment_method_added_successfully)
                }
            )
        }.launchIn(viewModelScope)
    }

    private fun inferPaymentType(method: String): PaymentMethodType {
        return when {
            method.startsWith("4") -> PaymentMethodType.VISA
            method.startsWith("5") -> PaymentMethodType.MASTERCARD
            else -> PaymentMethodType.PAYPAL // Default type if not Visa or Mastercard
        }
    }
}
