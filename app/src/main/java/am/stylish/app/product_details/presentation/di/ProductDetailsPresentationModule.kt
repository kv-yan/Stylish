package am.stylish.app.product_details.presentation.di

import am.stylish.app.product_details.presentation.ProductDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val productDetailsPresentationModule = module {
    viewModelOf(::ProductDetailsViewModel)

    viewModel { (productId: String) ->
        ProductDetailsViewModel(productId = productId)
    }
}