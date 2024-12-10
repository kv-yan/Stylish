package am.stylish.app.main.home.presentation

import am.stylish.app.R
import am.stylish.app.common_domain.entity.WishedItem
import am.stylish.app.common_domain.utils.Result
import am.stylish.app.common_presentation.components.snackbars.SnackbarState
import am.stylish.app.main.home.domain.usecase.GetHomePageProductsUseCase
import am.stylish.app.main.wishlist.domain.usecase.InsertWishedItemUseCase
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomeViewModel(
    private val insertWishedItemUseCase: InsertWishedItemUseCase,
    private val getHomePageProductsUseCase: GetHomePageProductsUseCase,
) : ViewModel() {
    private val _screenState = MutableStateFlow<HomeScreenState>(HomeScreenState.Loading)
    val screenState = _screenState.asStateFlow()

    init {
        fetchPageProducts()
    }

    private fun fetchPageProducts() {
        _screenState.value = HomeScreenState.Loading
        getHomePageProductsUseCase.invoke().onEach {
            _screenState.value = HomeScreenState.Success(it)
        }.catch {
            _screenState.value = HomeScreenState.Error(R.string.something_went_wrong)
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }

    fun addToWishlist(productId: String, onAction: (SnackbarState) -> Unit) {
        insertWishedItemUseCase.invoke(WishedItem(productId)).onEach {
            onAction(
                when (it) {
                    is Result.Error<*> -> {
                        SnackbarState.Error(
                            _message = R.string.something_went_wrong,
                            _icon = R.drawable.ic_error,
                        )
                    }

                    is Result.Success<*> -> {
                        SnackbarState.Success(
                            _message = R.string.product_added_to_wishlist,
                            _icon = R.drawable.ic_favorite_filled,
                        )
                    }
                }
            )
        }.catch {
            onAction(
                SnackbarState.Error(
                    _message = R.string.something_went_wrong,
                    _icon = R.drawable.ic_error
                )
            )
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }
}
