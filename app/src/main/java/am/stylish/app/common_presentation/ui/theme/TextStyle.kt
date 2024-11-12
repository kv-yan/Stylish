package am.stylish.app.common_presentation.ui.theme

import am.stylish.app.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


val RegularTextStyle = TextStyle(
    fontSize = 18.sp,
    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
    fontWeight = FontWeight(600),
)

val RegularDescriptionTextStyle = TextStyle(
    fontSize = 14.sp,
    lineHeight = 24.sp,
    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
    fontWeight = FontWeight(600),
    color = descriptionColor,
    textAlign = TextAlign.Center,
    letterSpacing = 0.28.sp,
)
