package am.stylish.app.common_presentation.di

import am.stylish.app.common_presentation.view_model.CartViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val commonPresentationModule = module {
    viewModelOf(::CartViewModel)
}