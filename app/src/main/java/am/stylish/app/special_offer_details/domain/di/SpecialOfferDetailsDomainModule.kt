package am.stylish.app.special_offer_details.domain.di

import am.stylish.app.special_offer_details.domain.usecase.GetSpecialOfferDetailsUseCase
import am.stylish.app.special_offer_details.domain.usecase.GetSpecialOfferDetailsUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val specialOfferDetailsDomainModule = module {
    factoryOf(::GetSpecialOfferDetailsUseCaseImpl) { bind<GetSpecialOfferDetailsUseCase>() }
}