package am.stylish.app.common_presentation.components.text


import am.stylish.app.R
import am.stylish.app.common_presentation.ui.theme.DarkGrayText
import am.stylish.app.common_presentation.ui.theme.LightGrayBackground
import am.stylish.app.common_presentation.ui.theme.MediumGrayBorder
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun AuthTextField(
    modifier: Modifier = Modifier,
    text: String = "Enter text here",
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isPasswordField: Boolean = false // Add a parameter to toggle password mode
) {
    var textFieldValue by remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }
    var isPasswordVisible by remember { mutableStateOf(false) } // Track password visibility

    Box(
        modifier = modifier
            .border(
                width = 1.dp,
                color = if (isFocused) MediumGrayBorder else MediumGrayBorder.copy(alpha = 0.5f),
                shape = RoundedCornerShape(10.dp)
            )
            .background(if (isFocused) LightGrayBackground else LightGrayBackground.copy(alpha = 0.5f))
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (leadingIcon != null) {
                Spacer(modifier = Modifier.width(12.dp))
                leadingIcon()
            }

            BasicTextField(
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 16.dp)
                    .weight(1f)
                    .onFocusChanged { isFocused = it.isFocused },
                value = textFieldValue,
                onValueChange = { textFieldValue = it },
                singleLine = true,
                visualTransformation = if (isPasswordField && !isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
                cursorBrush = SolidColor(DarkGrayText),
                textStyle = TextStyle(color = DarkGrayText),
                decorationBox = { innerTextField ->
                    if (textFieldValue.isEmpty()) {
                        Text(
                            text = text, color = DarkGrayText.copy(alpha = 0.5f)
                        )
                    }
                    innerTextField()
                },
            )

            if (isPasswordField) {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter =
                        painterResource(
                            if (isPasswordVisible) R.drawable.ic_visibility_off
                            else R.drawable.ic_visibility
                        ),
                        contentDescription =
                        if (isPasswordVisible)
                            stringResource(R.string.hide_password)
                        else
                            stringResource(R.string.show_password),
                        tint = DarkGrayText
                    )
                }
            } else if (trailingIcon != null) {
                trailingIcon()
            }
        }
    }
}

@Preview
@Composable
private fun AuthTextFieldPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AuthTextField(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.username_or_email),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Person,
                    contentDescription = null,
                    tint = DarkGrayText
                )
            })

        AuthTextField(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.password),
            isPasswordField = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Lock, contentDescription = null, tint = DarkGrayText
                )
            }
        )
    }
}
