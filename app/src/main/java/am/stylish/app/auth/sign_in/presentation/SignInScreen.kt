package am.stylish.app.auth.sign_in.presentation

import am.stylish.app.R
import am.stylish.app.auth.authwithsection.AuthWithSection
import am.stylish.app.common_presentation.components.button.SolidButton
import am.stylish.app.common_presentation.components.text.AuthTextField
import am.stylish.app.common_presentation.components.text.AuthTitle
import am.stylish.app.common_presentation.ui.theme.DarkGrayText
import am.stylish.app.common_presentation.ui.theme.RoseRed
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    navigateToForgotPassword: () -> Unit = {},
    navigateToSignUp: () -> Unit = {},
    navigateToMain: () -> Unit = {},
) {
    SignInContent(
        modifier = modifier.fillMaxSize(),
        navigateToForgotPassword = navigateToForgotPassword,
        navigateToSignUp = navigateToSignUp,
        navigateToMain = navigateToMain,
    )
}

@Composable
private fun SignInContent(
    modifier: Modifier = Modifier,
    navigateToForgotPassword: () -> Unit = {},
    navigateToSignUp: () -> Unit = {},
    navigateToMain: () -> Unit = {}
) {
    val verticalScroll = rememberScrollState()
    Column(modifier = modifier) {
        AuthTitle(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(verticalScroll),
            title = stringResource(R.string.welcome_back),
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

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 52.dp, top = 8.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            Text(
                modifier = Modifier.clickable { navigateToForgotPassword() },
                text = stringResource(R.string.forgot_password), style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                    fontWeight = FontWeight.W400,
                    color = RoseRed,
                )
            )
        }

        SolidButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 72.dp),
            text = stringResource(R.string.logIn)
        ) {
            navigateToMain()
        }

        AuthWithSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 124.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.Top,
            ) {
                Text(
                    text = stringResource(R.string.create_an_account),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF575757),
                    ),
                )

                Text(
                    text = stringResource(R.string.sign_up),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFFF83758),
                        textDecoration = TextDecoration.Underline,
                    ),
                    modifier = Modifier.clickable {
                        navigateToSignUp()
                    },
                )
            }
        }
    }
}