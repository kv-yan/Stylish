package am.stylish.app.product_details.presentation

import am.stylish.app.R
import am.stylish.app.common_domain.entity.WishedItem
import am.stylish.app.common_domain.utils.Result
import am.stylish.app.common_presentation.components.snackbar.SnackbarState
import am.stylish.app.common_presentation.utils.test_mock_data.productDetailsMockData
import am.stylish.app.main.wishlist.domain.usecase.DeleteWishedItemUseCase
import am.stylish.app.main.wishlist.domain.usecase.GetWishedListUseCase
import am.stylish.app.main.wishlist.domain.usecase.InsertWishedItemUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ProductDetailsViewModel(
    private val productId: String,
    private val insertWishedItemUseCase: InsertWishedItemUseCase,
    private val deleteWishedItemUseCase: DeleteWishedItemUseCase,
    private val getWishedListUseCase: GetWishedListUseCase
) : ViewModel() {
    private val _screenState = MutableStateFlow<DetailsScreenState>(DetailsScreenState.Loading)
    val screenState = _screenState.asStateFlow()

    private val _isWishlistAdded = MutableStateFlow(false)
    val isWishlistAdded = _isWishlistAdded.asStateFlow()

    init {
        fetchProductDetails()
    }

    private fun fetchProductDetails() {
        _screenState.value = DetailsScreenState.Loading
        productDetailsMockData.find { it.productId == productId }?.let {
            checkIfItemIsWished(productId)
            _screenState.value = DetailsScreenState.Success(it)
        } ?: run {
            _screenState.value = DetailsScreenState.Error(R.string.product_not_found)
        }
    }

    fun toggleWishlist(
        id: String,
        onAction: (SnackbarState) -> Unit = {},
    ) {
        if (_isWishlistAdded.value) {
            deleteFromWishlist(id, onAction)
        } else {
            addToWishlist(id, onAction)
        }
    }

    private fun addToWishlist(productId: String, onAction: (SnackbarState) -> Unit = {}) {
        insertWishedItemUseCase.invoke(WishedItem(productId)).map {
            onAction(
                when (it) {
                    is Result.Error<*> -> {
                        SnackbarState.Error(
                            R.string.something_went_wrong,
                            R.drawable.ic_error,
                        )
                    }

                    is Result.Success<*> -> {
                        SnackbarState.Success(
                            R.string.product_added_to_wishlist,
                            R.drawable.ic_favorite_filled,
                        )
                    }
                }
            )
        }.launchIn(viewModelScope)
    }

    private fun deleteFromWishlist(productId: String, onAction: (SnackbarState) -> Unit = {}) {
        deleteWishedItemUseCase.invoke(WishedItem(productId)).map {
            onAction(
                when (it) {
                    is Result.Error<*> -> {
                        SnackbarState.Error(
                            R.string.something_went_wrong,
                            R.drawable.ic_error,
                        )
                    }

                    is Result.Success<*> -> {
                        SnackbarState.Error(
                            R.string.product_deleted_successfully,
                            R.drawable.ic_delete,
                        )
                    }
                }

            )
        }.launchIn(viewModelScope)
    }

    private fun checkIfItemIsWished(productId: String) {
        viewModelScope.launch {
            getWishedListUseCase.invoke().collect { wishedList ->
                _isWishlistAdded.value = wishedList.any { it.id == productId }
            }
        }
    }
}