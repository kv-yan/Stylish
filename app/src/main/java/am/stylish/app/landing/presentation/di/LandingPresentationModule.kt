package am.stylish.app.landing.presentation.di

import am.stylish.app.landing.presentation.LandingViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val landingPresentationModule = module {
    viewModelOf(::LandingViewModel)
}