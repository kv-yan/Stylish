package am.stylish.app.checkout.presentation.di

import am.stylish.app.checkout.presentation.CheckoutViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val checkoutPresentationModule = module {

    viewModel { (totalPrice: Int) ->
        CheckoutViewModel(totalPrice)
    }
}