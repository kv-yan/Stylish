package am.stylish.app.add_payment_method.domain.model

import am.stylish.app.R

data class PaymentMethod(
    val value: String,
    val type: PaymentMethodType
)

enum class PaymentMethodType(val value: String, val image: Int) {
    VISA("Visa", R.drawable.ic_visa),
    MASTERCARD("Mastercard", R.drawable.ic_mastercard),
    PAYPAL("PayPal", R.drawable.ic_pay_pal),
    UNKNOWN("Unknown", R.drawable.ic_unknown)
}
