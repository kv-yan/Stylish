package am.stylish.app.order_details_screen.presentation.di

import am.stylish.app.order_details_screen.presentation.OrderDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val orderDetailsPresentationModule = module {

    viewModel { (productList: List<String>) ->
        OrderDetailsViewModel(productList)
    }
}