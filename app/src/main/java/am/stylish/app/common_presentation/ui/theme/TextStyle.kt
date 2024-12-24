package am.stylish.app.common_presentation.ui.theme

import am.stylish.app.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp


val RegularTextStyle = TextStyle(
    fontSize = 18.sp,
    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
    fontWeight = FontWeight.W600,
)

val RegularDescriptionTextStyle = TextStyle(
    fontSize = 14.sp,
    lineHeight = 24.sp,
    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
    fontWeight = FontWeight.W600,
    color = DescriptionColor,
    textAlign = TextAlign.Center,
    letterSpacing = 0.28.sp,
)


val AuthTitleTextStyle = TextStyle(
    color = Color.Black,
    fontSize = 36.sp,
    lineHeight = 43.sp,
    fontFamily = FontFamily(Font(R.font.montserrat_bold)),
    fontWeight = FontWeight.W700
)

val BottomBarItemTextStyle = TextStyle(
    fontSize = 12.sp,
    lineHeight = 16.sp,
    fontFamily = FontFamily(Font(R.font.roboto_mono_medium)),
    fontWeight = FontWeight.W400,
    color = Color.Black,
    letterSpacing = 0.4.sp,
)

val ProductTitleTextStyle = TextStyle(
    fontSize = 16.sp,
    lineHeight = 20.sp,
    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
    fontWeight = FontWeight.W500,
    color = Color.Black,
)

val ProductDescriptionTextStyle = TextStyle(
    fontSize = 10.sp,
    lineHeight = 16.sp,
    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
    fontWeight = FontWeight.W400,
    color = Color.Black,
)

val ProductPriceTextStyle = TextStyle(
    fontSize = 12.sp,
    lineHeight = 16.sp,
    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
    fontWeight = FontWeight.W500,
    color = Color.Black,
)
val ProductOldPriceTextStyle = TextStyle(
    fontSize = 12.sp,
    lineHeight = 16.sp,
    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
    fontWeight = FontWeight.W300,
    color = MutedTeal,
    textDecoration = TextDecoration.LineThrough,
)


val ProductDiscountTextStyle = TextStyle(
    fontSize = 10.sp,
    lineHeight = 16.sp,
    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
    fontWeight = FontWeight.W400,
    color = CoralRed,
    textAlign = TextAlign.Center,
)

val ProductReviewQuantityTextStyle = TextStyle(
    fontSize = 10.sp,
    lineHeight = 16.sp,
    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
    fontWeight = FontWeight.W400,
    color = SoftSteel,
)

val SpecialOfferTitleTextStyle = TextStyle(
    fontSize = 16.sp,
    lineHeight = 20.sp,
    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
    fontWeight = FontWeight.W500,
)

val SpecialOfferDescriptionTextStyle = TextStyle(
    fontSize = 12.sp,
    lineHeight = 16.sp,
    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
    fontWeight = FontWeight.W400,
)

val SplashLogoTextStyle = TextStyle(
    fontSize = 40.sp,
    lineHeight = 22.sp,
    fontFamily = FontFamily(Font(R.font.libre_caslon_text_bold)),
    fontWeight = FontWeight.W700,
    color = RoseRed,
)

val ActionBarLogoTextStyle = TextStyle(
    fontSize = 18.sp,
    lineHeight = 22.sp,
    fontFamily = FontFamily(Font(R.font.libre_caslon_text_bold)),
    fontWeight = FontWeight.W700,
    color = DodgerBlue,
    textAlign = TextAlign.Center,
)

val PurchaseButtonTextStyle = TextStyle(
    fontSize = 16.sp,
    lineHeight = 20.sp,
    fontFamily = FontFamily(Font(R.font.montserrat_bold)),
    fontWeight = FontWeight.W500,
    color = Color.White,
)

val AppSubtitleTextStyle = TextStyle(
    fontSize = 15.sp,
    lineHeight = 22.sp,
    fontFamily = FontFamily(Font(R.font.montserrat_bold)),
    fontWeight = FontWeight.W100,
    color = Color.Black,
)

val AddressTitleTextStyle = TextStyle(
    fontSize = 14.sp,
    lineHeight = 18.sp,
    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
    fontWeight = FontWeight(400),
    color = Color.Black,
)
