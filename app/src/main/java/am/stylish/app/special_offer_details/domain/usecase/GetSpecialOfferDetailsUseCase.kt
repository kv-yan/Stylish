package am.stylish.app.special_offer_details.domain.usecase

import am.stylish.app.common_domain.model.product.PageProduct
import am.stylish.app.common_domain.model.special_offer.SpecialOffer
import am.stylish.app.common_presentation.utils.test_mock_data.mockPageProductData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface GetSpecialOfferDetailsUseCase {
    fun invoke(specialOfferId: String): Flow<Result<SpecialOffer>>
}

class GetSpecialOfferDetailsUseCaseImpl : GetSpecialOfferDetailsUseCase {
    override fun invoke(specialOfferId: String): Flow<Result<SpecialOffer>> = flow {
        val specialOffer = mockPageProductData.find {
            (it as? PageProduct.PageSpecialOffer)?.specialOffer?.offerId == specialOfferId
        } as PageProduct.PageSpecialOffer

        emit(Result.success(specialOffer.specialOffer))
    }
}