package am.stylish.app.add_payment_method.data.di

import am.stylish.app.add_payment_method.data.repo.PaymentRepositoryImpl
import am.stylish.app.add_payment_method.domain.repo.PaymentRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val addPaymentMethodsDataModule = module {
    singleOf(::PaymentRepositoryImpl) { bind<PaymentRepository>() }
}