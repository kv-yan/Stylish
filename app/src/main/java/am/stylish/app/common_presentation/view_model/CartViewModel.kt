package am.stylish.app.common_presentation.view_model

import am.stylish.app.R
import am.stylish.app.common_domain.entity.CartItem
import am.stylish.app.common_domain.utils.Result
import am.stylish.app.common_presentation.components.snackbar.SnackbarState
import am.stylish.app.common_presentation.utils.GeneralTags
import am.stylish.app.main.cart.domain.usecase.DeleteCartItemUseCase
import am.stylish.app.main.cart.domain.usecase.GetCartListUseCase
import am.stylish.app.main.cart.domain.usecase.InsertCartItemUseCase
import am.stylish.app.main.cart.domain.usecase.UpdateCartItemUseCase
import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CartViewModel(
    private val getCartListUseCase: GetCartListUseCase,
    private val insertCartItemUseCase: InsertCartItemUseCase,
    private val updateCartItemUseCase: UpdateCartItemUseCase,
    private val deleteCartItemUseCase: DeleteCartItemUseCase
) : ViewModel() {

    private val _cartList = MutableStateFlow<List<CartItem>>(emptyList())
    val cartList: StateFlow<List<CartItem>> = _cartList.asStateFlow()

    init {
        fetchCartList()
    }

    private fun fetchCartList() {
        getCartListUseCase.invoke().onEach {
            _cartList.value = it
        }.catch {
            Log.e(GeneralTags.ERROR_TAG, "fetchCartList: ${it.message}")
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }

    fun addCartItem(
        item: String, action: (SnackbarState) -> Unit = {}
    ) {
        insertCartItemUseCase.invoke(CartItem(item)).onEach {
            action(
                when (it) {
                    is Result.Error<*> -> SnackbarState.Error(
                        _message = R.string.something_went_wrong, R.drawable.ic_error
                    )

                    is Result.Success<*> -> SnackbarState.Success(
                        _message = R.string.item_added_to_cart, R.drawable.ic_cart
                    )
                }
            )
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }

    private fun updateCartItem(item: CartItem) {
        updateCartItemUseCase.invoke(item).onEach {

        }.launchIn(CoroutineScope(Dispatchers.IO))
    }

    fun deleteCartItem(id: String, action: (SnackbarState) -> Unit = {}) {
        deleteCartItemUseCase.invoke(CartItem(id)).onEach {
            action(
                when (it) {
                    is Result.Error<*> -> {
                        SnackbarState.Error(
                            _message = R.string.something_went_wrong, _icon = R.drawable.ic_error
                        )
                    }

                    is Result.Success<*> -> {
                        SnackbarState.Error(
                            _message = R.string.item_removed_from_cart,
                            _icon = R.drawable.ic_cart_removed
                        )
                    }
                }
            )
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }

    fun increaseQuantityAndUpdate(item: CartItem) {
        val newItem = item.copy(quantity = item.quantity + 1)
        updateCartItem(newItem)
    }

    fun decreaseQuantityAndUpdate(item: CartItem) {
        if (item.quantity == 1) {
            deleteCartItem(item.id)
        } else {
            val newItem = item.copy(quantity = item.quantity - 1)
            updateCartItem(newItem)
        }
    }

    fun isItemInCart(item: String): CartItem? {
        return _cartList.value.find { it.id == item }
    }
}