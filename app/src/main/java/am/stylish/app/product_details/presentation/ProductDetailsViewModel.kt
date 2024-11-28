package am.stylish.app.product_details.presentation

import am.stylish.app.R
import am.stylish.app.common_presentation.utils.test_mock_data.productDetailsMockData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductDetailsViewModel(private val productId: String) : ViewModel() {
    private val _screenState = MutableStateFlow<DetailsScreenState>(DetailsScreenState.Loading)
    val screenState = _screenState.asStateFlow()

    init {
        fetchProductDetails()
    }

    private fun fetchProductDetails() {
        _screenState.value = DetailsScreenState.Loading
        productDetailsMockData.find { it.productId == productId }?.let {
            _screenState.value = DetailsScreenState.Success(it)
        } ?: run {
            _screenState.value = DetailsScreenState.Error(R.string.product_not_found)
        }
    }
}