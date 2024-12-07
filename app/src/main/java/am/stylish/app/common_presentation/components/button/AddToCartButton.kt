package am.stylish.app.common_presentation.components.button

import am.stylish.app.R
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

@Composable
fun AddToCartButton(
    modifier: Modifier = Modifier,
    isAdded: Boolean = true,
    quantity: Int = 1,
    onClick: () -> Unit = {}
) {
    Box(modifier = modifier.clickable {
        onClick()
    }) {
        Box(
            modifier = modifier
                .padding(
                    horizontal = 8.dp,
                    vertical = 4.dp
                )
                .border(
                    width = 0.5.dp,
                    color = Color.Black,
                    shape = CircleShape,
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .padding(
                        horizontal = 8.dp,
                        vertical = 6.dp
                    )
                    .zIndex(2f),
                painter = painterResource(R.drawable.ic_add_to_cart),
                contentDescription = null,
                tint = Color.Black
            )
        }

        if (isAdded) {
            Surface(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(y = (-2).dp)
                    .size(18.dp),
                color = Color.Red,
                shape = CircleShape,
                shadowElevation = 1.dp,
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = quantity.toString(),
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun AddToCartButtonPrev() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        AddToCartButton()
    }
}