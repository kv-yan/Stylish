package am.stylish.app.special_offer_details.presentation

import am.stylish.app.common_presentation.utils.GeneralTags
import am.stylish.app.special_offer_details.domain.usecase.GetSpecialOfferDetailsUseCase
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SpecialOfferDetailsViewModel(
    specialOfferId: String,
    private val getSpecialOfferDetailsUseCase: GetSpecialOfferDetailsUseCase
) : ViewModel() {
    private val _screenState =
        MutableStateFlow<SpecialOfferDetailsScreenState>(SpecialOfferDetailsScreenState.Loading)
    val screenState: StateFlow<SpecialOfferDetailsScreenState> = _screenState

    init {
        fetchSpecialOfferDetails(specialOfferId)
    }

    private fun fetchSpecialOfferDetails(specialOfferId: String) {
        _screenState.value = SpecialOfferDetailsScreenState.Loading
        getSpecialOfferDetailsUseCase.invoke(specialOfferId).onEach {
            it.onSuccess { specialOffer ->
                _screenState.value = SpecialOfferDetailsScreenState.Success(specialOffer)
            }.onFailure { throwable ->
                _screenState.value =
                    SpecialOfferDetailsScreenState.Error(throwable.message ?: GeneralTags.ERROR_TAG)
            }
        }.catch {
            _screenState.value =
                SpecialOfferDetailsScreenState.Error(it.message ?: GeneralTags.ERROR_TAG)
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }
}