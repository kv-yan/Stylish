package am.stylish.app.product_category_details.presentation.di

import am.stylish.app.product_category_details.presentation.ProductCategoryDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val productCategoryDetailsPresentationModule = module {
    viewModel { (categoryId: String) ->
        ProductCategoryDetailsViewModel(
            categoryId = categoryId,
            getProductCategoryDetailsUseCase = get()
        )
    }
}