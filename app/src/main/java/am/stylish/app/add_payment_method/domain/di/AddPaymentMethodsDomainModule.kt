package am.stylish.app.add_payment_method.domain.di

import am.stylish.app.add_payment_method.domain.usecase.AddPaymentMethodUseCase
import am.stylish.app.add_payment_method.domain.usecase.AddPaymentMethodUseCaseImpl
import am.stylish.app.add_payment_method.domain.usecase.GetPaymentMethodsUseCase
import am.stylish.app.add_payment_method.domain.usecase.GetPaymentMethodsUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val addPaymentMethodsDomainModule = module {
    factoryOf(::AddPaymentMethodUseCaseImpl) { bind<AddPaymentMethodUseCase>() }
    factoryOf(::GetPaymentMethodsUseCaseImpl) { bind<GetPaymentMethodsUseCase>() }
}