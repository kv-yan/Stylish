package am.stylish.app.add_payment_method.data.repo

import am.stylish.app.add_payment_method.domain.model.PaymentMethod
import am.stylish.app.add_payment_method.domain.repo.PaymentRepository
import am.stylish.app.common_data.datastore.PaymentMethodDataStore
import kotlinx.coroutines.flow.map

class PaymentRepositoryImpl(
    private val dataSource: PaymentMethodDataStore
) : PaymentRepository {

    override fun getPaymentMethods() = dataSource.paymentMethods.map { methods ->
        methods.map { value ->
            PaymentMethod(
                value = value.value,
                type = value.type
            )
        }
    }

    override fun addPaymentMethod(paymentMethod: PaymentMethod) =
        dataSource.savePaymentMethod(paymentMethod)

}
