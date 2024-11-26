package am.stylish.app.common_presentation.components.pager


import am.stylish.app.common_presentation.ui.theme.CoolGray
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun PagerController(
    modifier: Modifier = Modifier,
    isShowingPrev: Boolean = true,
    isShowingNext: Boolean = true,
    onPrevClick: () -> Unit = {},
    onNextClick: () -> Unit = {}
) {
    Box(modifier = modifier) {
        AnimatedVisibility(
            visible = isShowingPrev,
            modifier = Modifier.align(Alignment.CenterStart),
        ) {
            IconButton(
                modifier = Modifier.padding(start = 16.dp),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = CoolGray.copy(alpha = 0.7f), contentColor = Color.Black
                ),
                onClick = {
                    onPrevClick()

                },
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null
                )
            }
        }

        AnimatedVisibility(
            visible = isShowingNext,
            modifier = Modifier.align(Alignment.CenterEnd),
        ) {
            IconButton(
                modifier = Modifier.padding(16.dp),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = CoolGray.copy(alpha = 0.7f), contentColor = Color.Black
                ),
                onClick = {
                    onNextClick()
                },
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null
                )
            }
        }
    }
}
