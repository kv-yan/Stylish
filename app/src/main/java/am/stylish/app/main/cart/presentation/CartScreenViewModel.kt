package am.stylish.app.main.cart.presentation

import am.stylish.app.common_presentation.utils.test_mock_data.mockProductsData
import am.stylish.app.main.cart.domain.usecase.DeleteCartItemUseCase
import am.stylish.app.main.cart.domain.usecase.GetCartListUseCase
import am.stylish.app.main.cart.domain.usecase.InsertCartItemUseCase
import am.stylish.app.main.cart.domain.usecase.UpdateCartItemUseCase
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CartScreenViewModel(
    private val getCartListUseCase: GetCartListUseCase,
    private val insertCartItemUseCase: InsertCartItemUseCase,
    private val updateCartItemUseCase: UpdateCartItemUseCase,
    private val deleteCartItemUseCase: DeleteCartItemUseCase
) : ViewModel() {
    private val _screenState = MutableSharedFlow<CartScreenState>()
    val screenState = _screenState.asSharedFlow()

    fun fetchCartItems() {
        _screenState.tryEmit(CartScreenState.Loading)

        getCartListUseCase.invoke().onEach { cartItems ->
            val products = cartItems.flatMap { cartItem ->
                mockProductsData.filter { product ->
                    product.id == cartItem.id
                }
            }
            _screenState.emit(CartScreenState.Success(products))
        }.catch { exception ->
            _screenState.emit(
                CartScreenState.Error(
                    exception.message ?: "An error occurred"
                )
            )
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }
}
