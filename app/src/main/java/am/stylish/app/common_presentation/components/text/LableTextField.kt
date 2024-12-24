package am.stylish.app.common_presentation.components.text

import am.stylish.app.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LabeledInputText(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    aimAction: ImeAction = ImeAction.Next,
    visualTransformation: VisualTransformation? = null,
    limit: Int? = null,
    onValueChange: (String) -> Unit = {}
) {

    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(
            text = label,
            style = TextStyle(
                fontSize = 15.sp,
                lineHeight = 22.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                fontWeight = FontWeight.W200,
            )
        )


        InputTextField(
            modifier = Modifier.fillMaxWidth(),
            text = value,
            limit = limit,
            visualTransformation = visualTransformation,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = aimAction
            ),
            onValueChange = onValueChange
        )
    }
}

@Preview
@Composable
private fun LabeledInputTextPrev() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        LabeledInputText(
            label = stringResource(R.string.card_number),
            value = stringResource(R.string.empty_string),
            onValueChange = {}
        )

        LabeledInputText(
            label = stringResource(R.string.card_holder_name),
            value = stringResource(R.string.empty_string),
            onValueChange = {},
        )

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            LabeledInputText(
                modifier = Modifier.weight(1f),
                label = stringResource(R.string.expiry_date),
                value = stringResource(R.string.empty_string),
                onValueChange = {}
            )

            LabeledInputText(modifier = Modifier.weight(1f),
                label = stringResource(R.string.security_code),
                value = stringResource(R.string.empty_string),
                onValueChange = {})
        }
    }

}