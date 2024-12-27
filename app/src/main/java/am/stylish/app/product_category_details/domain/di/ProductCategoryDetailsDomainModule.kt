package am.stylish.app.product_category_details.domain.di

import am.stylish.app.product_category_details.domain.usecase.GetProductCategoryDetailsUseCase
import am.stylish.app.product_category_details.domain.usecase.GetProductCategoryDetailsUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val productCategoryDetailsDomainModule = module {
    factoryOf(::GetProductCategoryDetailsUseCaseImpl) { bind<GetProductCategoryDetailsUseCase>() }
}