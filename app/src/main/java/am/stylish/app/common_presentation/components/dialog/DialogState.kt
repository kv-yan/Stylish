package am.stylish.app.common_presentation.components.dialog

sealed class DialogState {
    class Success(val message: String? = null) : DialogState()
    data object Loading : DialogState()
    class Error(val message: String? = null) : DialogState()
}