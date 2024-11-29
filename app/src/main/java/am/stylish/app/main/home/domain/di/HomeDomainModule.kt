package am.stylish.app.main.home.domain.di

import am.stylish.app.main.home.domain.usecase.GetHomePageProductsUseCase
import am.stylish.app.main.home.domain.usecase.GetHomePageProductsUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val homeDomainModule = module {
    factoryOf(::GetHomePageProductsUseCaseImpl) { bind<GetHomePageProductsUseCase>() }
}