package am.stylish.app.main.cart.presentation.di

import am.stylish.app.main.cart.presentation.CartScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val cartPresentationModule = module {
    viewModelOf(::CartScreenViewModel)
}