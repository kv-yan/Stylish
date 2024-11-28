package am.stylish.app.landing.presentation.di

import am.stylish.app.landing.presentation.LandingViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val landingPresentationModule = module {
    viewModelOf(::LandingViewModel)
}