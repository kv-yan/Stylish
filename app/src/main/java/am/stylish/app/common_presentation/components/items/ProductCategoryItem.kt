package am.stylish.app.common_presentation.components.items

import am.stylish.app.R
import am.stylish.app.main.search.domain.model.ProductCategory
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductCategoryItem(
    modifier: Modifier = Modifier,
    productCategory: ProductCategory,
    onClick: () -> Unit = {}
) {

    Column(
        modifier = modifier.clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier
                .size(90.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(16.dp)),
            painter = painterResource(id = productCategory.image),
            contentDescription = productCategory.name,
            contentScale = ContentScale.Fit

        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            text = productCategory.name,
            style = TextStyle(
                fontSize = 10.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                fontWeight = FontWeight.W400,
                color = Color(0xFF21003D),
                textAlign = TextAlign.Center,
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

