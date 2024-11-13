package am.stylish.app.auth.sign_up.presentation

import am.stylish.app.R
import am.stylish.app.auth.authwithsection.AuthWithSection
import am.stylish.app.common_presentation.components.button.SolidButton
import am.stylish.app.common_presentation.components.text.AuthTextField
import am.stylish.app.common_presentation.components.text.AuthTitle
import am.stylish.app.common_presentation.ui.theme.DarkGrayText
import am.stylish.app.common_presentation.ui.theme.LightGrayText
import am.stylish.app.common_presentation.ui.theme.RoseRed
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    navigateToSignIn: () -> Unit = {},
    navigateToMain: () -> Unit = {},
) {
    SignUpScreenContent(
        modifier = modifier, navigateToSignIn = navigateToSignIn, navigateToMain = navigateToMain
    )
}

@Composable
fun SignUpScreenContent(
    modifier: Modifier = Modifier,
    navigateToSignIn: () -> Unit = {},
    navigateToMain: () -> Unit = {},
) {
    val verticalScroll = rememberScrollState()
    Column(
        modifier = modifier
            .verticalScroll(verticalScroll)
            .fillMaxSize()
            .imePadding()
    ) {
        AuthTitle(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(R.string.create_an_account_capitalize),
        )

        AuthTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 36.dp),
            text = stringResource(R.string.username_or_email),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Person,
                    contentDescription = null,
                    tint = DarkGrayText
                )
            })

        AuthTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp),
            text = stringResource(R.string.password),
            isPasswordField = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Lock, contentDescription = null, tint = DarkGrayText
                )
            })

        AuthTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp),
            text = stringResource(R.string.confirm_password),
            isPasswordField = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Lock, contentDescription = null, tint = DarkGrayText
                )
            })

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 38.dp, top = 18.dp),
        ) {
            Text(
                text = buildAnnotatedString {
                    append(stringResource(R.string.by_clicking_the))
                    withStyle(style = SpanStyle(color = RoseRed)) {
                        append(stringResource(R.string.register))
                    }
                    append(stringResource(R.string.button_you_agree_to_the_public_offer))
                }, style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                    fontWeight = FontWeight.W400,
                    color = Color(0xFF676767)
                )
            )
        }

        SolidButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp),
            text = stringResource(R.string.create_account)
        ) {
            navigateToMain()
        }

        AuthWithSection(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.Top,
            ) {
                Text(
                    text = stringResource(R.string.i_already_have_an_account),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                        fontWeight = FontWeight.W400,
                        color = LightGrayText,
                    ),
                )

                Text(
                    text = stringResource(R.string.logIn),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                        fontWeight = FontWeight.W600,
                        color = RoseRed,
                        textDecoration = TextDecoration.Underline,
                    ),
                    modifier = Modifier.clickable {
                        navigateToSignIn()
                    },
                )
            }
        }
    }

}