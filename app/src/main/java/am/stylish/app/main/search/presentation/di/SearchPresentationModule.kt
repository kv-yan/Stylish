package am.stylish.app.main.search.presentation.di

import am.stylish.app.main.search.presentation.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val searchPresentationModule = module {
    viewModelOf(::SearchViewModel)
}