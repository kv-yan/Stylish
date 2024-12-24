package am.stylish.app.add_payment_method.domain.usecase

import am.stylish.app.add_payment_method.domain.model.PaymentMethod
import am.stylish.app.add_payment_method.domain.repo.PaymentRepository
import kotlinx.coroutines.flow.Flow

interface GetPaymentMethodsUseCase {
    fun invoke(): Flow<List<PaymentMethod>>
}

class GetPaymentMethodsUseCaseImpl(
    private val repository: PaymentRepository
) : GetPaymentMethodsUseCase {

    override fun invoke() =
        repository.getPaymentMethods()

}

