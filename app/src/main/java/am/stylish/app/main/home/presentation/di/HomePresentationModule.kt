package am.stylish.app.main.home.presentation.di

import am.stylish.app.main.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val homePresentationModule = module {
    viewModelOf(::HomeViewModel)
}