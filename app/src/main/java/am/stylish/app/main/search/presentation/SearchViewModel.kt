package am.stylish.app.main.search.presentation

import am.stylish.app.common_domain.utils.Result
import am.stylish.app.main.search.domain.model.ProductCategory
import am.stylish.app.main.search.domain.usecase.GetProductCategoriesUseCase
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SearchViewModel(
    getProductCategoriesUseCase: GetProductCategoriesUseCase
) : ViewModel() {

    private val _screenState = MutableStateFlow<SearchScreenState>(SearchScreenState.Loading)
    val screenState: StateFlow<SearchScreenState> = _screenState.asStateFlow()

    init {
        val coroutineScope = CoroutineScope(Dispatchers.IO)
        getProductCategoriesUseCase.invoke().onEach {
            _screenState.value =
                when (it) {
                    is Result.Error<*> -> SearchScreenState.Error("Something went wrong")
                    is Result.Success<*> -> SearchScreenState.Success(it.data as List<ProductCategory>)
                }
        }.launchIn(coroutineScope)
    }
}