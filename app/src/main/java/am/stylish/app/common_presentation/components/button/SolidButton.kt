package am.stylish.app.common_presentation.components.button

import am.stylish.app.R
import am.stylish.app.common_presentation.ui.theme.RoseRed
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SolidButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit = {}) {
    Button(
        modifier = modifier, onClick = { onClick() },
        shape = RoundedCornerShape(4.dp),
        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
            containerColor = RoseRed,
            contentColor = Color.White
        )
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                fontWeight = FontWeight.W600,
            ),
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}