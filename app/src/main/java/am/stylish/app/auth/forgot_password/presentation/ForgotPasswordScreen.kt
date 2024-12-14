package am.stylish.app.auth.forgot_password.presentation

import am.stylish.app.R
import am.stylish.app.common_presentation.components.button.SolidButton
import am.stylish.app.common_presentation.components.text.InputTextField
import am.stylish.app.common_presentation.components.text.AuthTitle
import am.stylish.app.common_presentation.ui.theme.DarkGrayText
import am.stylish.app.common_presentation.ui.theme.RoseRed
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ForgotPasswordScreen(modifier: Modifier = Modifier, navigateToMain: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .imePadding()
    ) {
        AuthTitle(
            modifier = Modifier.padding(bottom = 32.dp),
            title = stringResource(R.string.forgot_password_title)
        )

        InputTextField(modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.enter_your_email_address),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = null,
                    tint = DarkGrayText
                )
            }
        )

        Text(
            modifier = Modifier.padding(vertical = 26.dp), text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = RoseRed)) {
                    append(stringResource(R.string.star_symbol))
                }
                append(stringResource(R.string.we_will_send_you_a_message_to_set_or_reset_your_new_password))
            }, style = TextStyle(
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                fontWeight = FontWeight.W400,
                color = Color(0xFF676767)
            )
        )
        SolidButton(Modifier.fillMaxWidth(), text = stringResource(R.string.submit)) {
            navigateToMain()
        }
    }
}
