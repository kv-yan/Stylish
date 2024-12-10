package am.stylish.app.common_presentation.components.snackbars

import am.stylish.app.R

sealed class SnackbarState(val icon: Int?, val action: () -> Unit, val message: Int) {
    data class Error(
        val _message: Int = R.string.empty_string,
        val _icon: Int? = R.drawable.ic_error,
        val _action: () -> Unit = {}
    ) : SnackbarState(icon = _icon, action = _action, message = _message)

    data class Success(
        val _message: Int = R.string.empty_string,
        val _icon: Int? = null,
        val _action: () -> Unit = {}
    ) : SnackbarState(icon = _icon, action = _action, message = _message)
}