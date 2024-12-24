package am.stylish.app.main.wishlist.presentation

import am.stylish.app.common_domain.model.product.Product
import am.stylish.app.common_presentation.utils.GeneralTags
import am.stylish.app.common_presentation.utils.test_mock_data.mockProductsData
import am.stylish.app.main.wishlist.domain.usecase.GetWishedListUseCase
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.plus

class WishlistViewModel(
    private val getWishedListUseCase: GetWishedListUseCase
) : ViewModel() {
    private val _wishlistScreenState =
        MutableStateFlow<WishlistScreenState>(WishlistScreenState.Loading)
    val wishlistScreenState: StateFlow<WishlistScreenState> = _wishlistScreenState

    init {
        fetchWishlistItems()
    }

    fun fetchWishlistItems() {
        val wishlistItems = mutableListOf<Product>()
        getWishedListUseCase.invoke().onEach { wishedItemList ->
            wishlistItems.clear()

            wishedItemList.map { item ->
                mockProductsData.forEach { product ->
                    if (product.id == item.id) {
                        wishlistItems.add(product)
                    }
                }
            }

            _wishlistScreenState.value = WishlistScreenState.Success(wishlistItems)

        }.catch {
            Log.e(GeneralTags.ERROR_TAG, "fetchWishlistItems :: ${it.message}")
        }.launchIn(viewModelScope.plus(Dispatchers.IO))
    }
}
