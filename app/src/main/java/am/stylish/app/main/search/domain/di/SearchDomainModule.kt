package am.stylish.app.main.search.domain.di

import am.stylish.app.main.search.domain.usecase.GetProductCategoriesUseCase
import am.stylish.app.main.search.domain.usecase.GetProductCategoriesUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val searchDomainModule = module {
    factoryOf(::GetProductCategoriesUseCaseImpl) { bind<GetProductCategoriesUseCase>() }
}