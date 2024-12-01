package am.stylish.app.main.checkout

import am.stylish.app.R
import am.stylish.app.common_presentation.components.button.SolidButton
import am.stylish.app.common_presentation.components.text.AuthTextField
import am.stylish.app.common_presentation.ui.theme.ProductPriceTextStyle
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CheckoutScreen() {
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
        SectionEditProfilePicture()
        SectionPersonalDetails(email, password)
        Divider()
        SectionBusinessAddressDetails(pinCode, address, city, state, country)
        Divider()
        SectionBankAccountDetails(bankAccNumber, accHolderName, ifsqCode)
        SolidButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, bottom = 40.dp),
            text = stringResource(R.string.save)
        )
    }
}

@Composable
private fun Divider() {
    HorizontalDivider(
        modifier = Modifier.padding(top = 30.dp),
        color = Color.Black,
        thickness = 1.dp
    )
}

@Composable
fun SectionBankAccountDetails(bankAccNumber: String, accHolderName: String, codeIFSC: String) {
    var bankAccNumber = bankAccNumber
    var accHolderName = accHolderName
    var codeIFSC = codeIFSC

    SectionLabel(stringResource(R.string.bank_account_details))
    SectionFieldTitleAndText(stringResource(R.string.bank_account_number), bankAccNumber)
    SectionFieldTitleAndText(stringResource(R.string.account_holder_s_name), accHolderName)
    SectionFieldTitleAndText(stringResource(R.string.ifsc_code), codeIFSC)
}


@Composable
fun SectionBusinessAddressDetails(
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
    SectionLabel(stringResource(R.string.business_address_details))
    SectionFieldTitleAndText(stringResource(R.string.pin_code), pinCode)
    SectionFieldTitleAndText(stringResource(R.string.address), address)
    SectionFieldTitleAndText(stringResource(R.string.city), city)
    SectionFieldTitleAndText(stringResource(R.string.state), state)
    SectionFieldTitleAndText(stringResource(R.string.country), country)
}

@Composable
private fun SectionLabel(string: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp),
        text = string,
        fontSize = 18.sp, fontFamily = FontFamily(Font(R.font.montserrat_semibold))
    )
}

@Composable
private fun SectionFieldTitleAndText(label: String, string: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        text = label,
        style = ProductPriceTextStyle
    )
    AuthTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        isPasswordField = false,
        leadingIcon = null,
        text = string
    )
}

@Composable
private fun SectionPersonalDetails(email: String, password: String) {
    var email1 = email
    var password1 = password
    SectionLabel(stringResource(R.string.personal_details))
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        text = stringResource(R.string.email_address),
        style = ProductPriceTextStyle
    )
    AuthTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        isPasswordField = false,
        leadingIcon = null,
        text = email1
    )
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        text = stringResource(R.string.password),
        style = ProductPriceTextStyle
    )
    AuthTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        isPasswordField = true,
        text = password1
    )
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .clickable { },
        text = stringResource(R.string.change_password), textAlign = TextAlign.End,
        color = RoseRed,
        textDecoration = TextDecoration.Underline,
        style = ProductPriceTextStyle
    )
}

@Composable
private fun SectionEditProfilePicture() {
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