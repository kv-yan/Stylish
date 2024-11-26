package am.stylish.app.main.checkout

import am.stylish.app.R
import am.stylish.app.common_presentation.components.button.SolidButton
import am.stylish.app.common_presentation.ui.theme.RoseRed

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CheckoutScreen() {
//    var text by remember { mutableStateOf("") } //???
    var email = ""
    var password = ""
    var pinCode = ""
    var address = ""
    var city = ""
    var state = ""
    var country = ""
    var bankAccNumber = ""
    var accHolderName = ""
    var ifsqCode = ""
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        imageEditView()
        personalDetailsView(email, password)
        divider()
        businessAddressDetails(pinCode, address, city, state, country)
        divider()
        bankAccountDetails(bankAccNumber, accHolderName, ifsqCode)
        SolidButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, bottom = 40.dp),
            text = stringResource(R.string.save))
    }
}

@Composable
private fun divider() {
    HorizontalDivider(
        modifier = Modifier.padding(top = 30.dp),
        color = Color.Black,
        thickness = 0.5.dp
    )
}

@Composable
fun bankAccountDetails(bankAccNumber: String, accHolderName: String, ifsqCode: String) {
    var bankAccNumber = bankAccNumber
    var accHolderName = accHolderName
    var ifsqCode = ifsqCode

    sectionLabel(stringResource(R.string.bank_account_details))
    titleAndText(stringResource(R.string.bank_account_number), bankAccNumber)
    titleAndText(stringResource(R.string.account_holder_s_name), accHolderName)
    titleAndText(stringResource(R.string.ifsc_code), ifsqCode)
}


@Composable
fun businessAddressDetails(
    pinCode: String,
    address: String,
    city: String,
    state: String,
    country: String
) {
    var pinCode = pinCode
    var address = address
    var city = city
    var state = state
    var country = country
    sectionLabel(stringResource(R.string.business_address_details))
    titleAndText(stringResource(R.string.pin_code), pinCode)
    titleAndText(stringResource(R.string.address), address)
    titleAndText(stringResource(R.string.city), city)
    titleAndText(stringResource(R.string.state), state)
    titleAndText(stringResource(R.string.country), country)
}

@Composable
private fun sectionLabel(string: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp),
        text = string,
        fontSize = 18.sp, fontFamily = FontFamily(Font(R.font.montserrat_semibold))
    )
}

@Composable
private fun titleAndText(label: String, string: String) {
    var localString = string
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        text = label,
        fontSize = 12.sp, fontFamily = FontFamily(Font(R.font.montserrat_regular))
    )
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        value = localString,
        onValueChange = { localString = it },
    )
}

@Composable
private fun personalDetailsView(email: String, password: String) {
    var email1 = email
    var password1 = password
    sectionLabel(stringResource(R.string.personal_details))
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        text = stringResource(R.string.email_address),
        fontSize = 12.sp, fontFamily = FontFamily(Font(R.font.montserrat_regular))
    )
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        value = email1,
        onValueChange = { email1 = it },
    )
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        text = stringResource(R.string.password),
        fontSize = 12.sp, fontFamily = FontFamily(Font(R.font.montserrat_regular))
    )
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = password1,
        visualTransformation = PasswordVisualTransformation(),
        onValueChange = { password1 = it },
    )
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .clickable { },
        text = stringResource(R.string.change_password), textAlign = TextAlign.End,
        color = RoseRed,
        textDecoration = TextDecoration.Underline,
        fontSize = 12.sp, fontFamily = FontFamily(Font(R.font.montserrat_regular))
    )
}

@Composable
private fun imageEditView() {
    Box(modifier = Modifier) {
        Image(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.ic_avatar),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )
        Image(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(32.dp),
            painter = painterResource(id = R.drawable.ic_edit),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GetStartedPreview() {
    CheckoutScreen()
}