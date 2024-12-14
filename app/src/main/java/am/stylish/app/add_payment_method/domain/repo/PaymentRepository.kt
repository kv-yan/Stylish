package am.stylish.app.add_payment_method.domain.repo

import am.stylish.app.add_payment_method.domain.model.PaymentMethod
import am.stylish.app.common_domain.utils.Result
import kotlinx.coroutines.flow.Flow

interface PaymentRepository {
    fun getPaymentMethods(): Flow<List<PaymentMethod>>
    fun addPaymentMethod(paymentMethod: PaymentMethod): Flow<Result>
}
