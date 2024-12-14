package am.stylish.app.common_presentation.components.checkbox

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppCheckBox(
    modifier: Modifier = Modifier.size(18.dp),
    checked: Boolean = true,
    onCheckedChange: (Boolean) -> Unit = {}
) {

    val background = if (checked) Color.Black else Color.White
    val border = if (checked) Color.White else Color.Black

    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(background)
            .border(
                width = 1.dp,
                color = border,
                shape = CircleShape
            )
            .clickable {
                onCheckedChange(!checked)
            },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.padding(2.dp),
            imageVector = Icons.Rounded.Check,
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Preview
@Composable
private fun AppCheckBoxPrev() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AppCheckBox()
    }
}