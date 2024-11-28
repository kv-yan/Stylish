package am.stylish.app.common_presentation.components.button

import am.stylish.app.common_presentation.ui.theme.Concrete
import am.stylish.app.common_presentation.ui.theme.MineShaft
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun IconButton(
    tint: Color = MineShaft,
    icon: @Composable () -> Unit,
    onClick: () -> Unit
) {
    androidx.compose.material3.IconButton(
        onClick = onClick,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Concrete,
            contentColor = tint,
        )
    ) {
        icon()
    }
}