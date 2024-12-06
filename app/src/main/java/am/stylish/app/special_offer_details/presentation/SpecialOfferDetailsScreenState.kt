package am.stylish.app.special_offer_details.presentation

import am.stylish.app.common_domain.model.special_offer.SpecialOffer

sealed class SpecialOfferDetailsScreenState {
    object Loading : SpecialOfferDetailsScreenState()
    data class Error(val message: String) : SpecialOfferDetailsScreenState()
    data class Success(val specialOffer: SpecialOffer) : SpecialOfferDetailsScreenState()

}