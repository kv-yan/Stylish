package am.stylish.app.special_offer_details.presentation.di

import am.stylish.app.special_offer_details.presentation.SpecialOfferDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val specialOfferDetailsPresentationModule = module {
    viewModel { (specialOfferId: String) ->
        SpecialOfferDetailsViewModel(
            specialOfferId = specialOfferId,
            getSpecialOfferDetailsUseCase = get()
        )
    }
}