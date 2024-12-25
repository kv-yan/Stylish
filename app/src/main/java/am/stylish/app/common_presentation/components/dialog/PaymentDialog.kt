package am.stylish.app.common_presentation.components.dialog

import am.stylish.app.R
import am.stylish.app.common_presentation.ui.theme.RegularTextStyle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay

@Composable
fun PaymentDialog(
    isExpanded: Boolean = true, dialogState: DialogState, onDismiss: () -> Unit = {}
) {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(
            when (dialogState) {
                is DialogState.Success -> R.raw.payment_success_anim
                is DialogState.Error -> R.raw.payment_error_anim
                else -> R.raw.loading_anim
            }
        )
    )
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever,
    )

    val dialogText = when (dialogState) {
        is DialogState.Success -> dialogState.message
        is DialogState.Error -> dialogState.message
        else -> null
    }


    if (isExpanded) {
        Dialog(onDismissRequest = onDismiss) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White, shape = RoundedCornerShape(16.dp))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {


                    LottieAnimation(
                        composition = composition,
                        progress = { progress },
                        modifier = Modifier.size(150.dp)
                    )


                    dialogText?.let {
                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = it, style = RegularTextStyle
                        )
                    }
                }
            }
        }

    }

}

@Preview
@Composable
private fun PaymentDialogPrev() {
    val isExpanded = remember { mutableStateOf(true) }
    val dialogState = remember { mutableStateOf<DialogState>(DialogState.Loading) }
    LaunchedEffect(Unit) {
        isExpanded.value = true
        dialogState.value = DialogState.Loading
        delay(2000)
        dialogState.value = DialogState.Success("Payment done successfully")
    }
    PaymentDialog(
        isExpanded = isExpanded.value, dialogState = dialogState.value
    ) {
        isExpanded.value = false
    }

}