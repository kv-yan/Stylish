package am.stylish.app.add_payment_method.domain.usecase

import am.stylish.app.add_payment_method.domain.model.PaymentMethod
import am.stylish.app.add_payment_method.domain.repo.PaymentRepository
import am.stylish.app.common_domain.utils.Result
import kotlinx.coroutines.flow.Flow

interface AddPaymentMethodUseCase {
    fun invoke(method: PaymentMethod): Flow<Result>
}

class AddPaymentMethodUseCaseImpl(
    private val repository: PaymentRepository
) : AddPaymentMethodUseCase {

    override fun invoke(method: PaymentMethod) =
        repository.addPaymentMethod(method)
}