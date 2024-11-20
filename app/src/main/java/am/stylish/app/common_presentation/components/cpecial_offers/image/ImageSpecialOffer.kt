package am.stylish.app.common_presentation.components.cpecial_offers.image

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun <T> ImageSpecialOffer(
    modifier: Modifier = Modifier,
    sourceList: T,
    imageLoader: @Composable (T) -> Unit,
    onClick: () -> Unit = {}
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            imageLoader(sourceList)
        }
    }
}