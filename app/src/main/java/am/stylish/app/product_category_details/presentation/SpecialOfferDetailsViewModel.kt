package am.stylish.app.product_category_details.presentation

import am.stylish.app.common_presentation.utils.GeneralTags
import am.stylish.app.product_category_details.domain.usecase.GetProductCategoryDetailsUseCase
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ProductCategoryDetailsViewModel(
    categoryId: String,
    private val getProductCategoryDetailsUseCase: GetProductCategoryDetailsUseCase
) : ViewModel() {
    private val _screenState =
        MutableStateFlow<ProductCategoryDetailsScreenState>(ProductCategoryDetailsScreenState.Loading)
    val screenState: StateFlow<ProductCategoryDetailsScreenState> = _screenState

    init {
        fetchSpecialOfferDetails(categoryId)
    }

    private fun fetchSpecialOfferDetails(specialOfferId: String) {
        _screenState.value = ProductCategoryDetailsScreenState.Loading
        getProductCategoryDetailsUseCase.invoke(specialOfferId).onEach {
            it.onSuccess { specialOffer ->
                _screenState.value = specialOffer?.let { it1 ->
                    ProductCategoryDetailsScreenState.Success(
                        it1
                    )
                } ?: ProductCategoryDetailsScreenState.Error("Something went wrong")
            }.onFailure { throwable ->
                _screenState.value =
                    ProductCategoryDetailsScreenState.Error(
                        throwable.message ?: GeneralTags.ERROR_TAG
                    )
            }
        }.catch {
            _screenState.value =
                ProductCategoryDetailsScreenState.Error(it.message ?: GeneralTags.ERROR_TAG)
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }
}