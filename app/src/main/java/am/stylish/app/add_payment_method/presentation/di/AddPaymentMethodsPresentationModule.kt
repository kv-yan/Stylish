package am.stylish.app.add_payment_method.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import am.stylish.app.add_payment_method.presentation.PaymentViewModel

val addPaymentMethodsPresentationModule = module {
    viewModelOf(::PaymentViewModel)
}