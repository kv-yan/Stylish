package am.stylish.app.common_presentation.components.items

import am.stylish.app.R
import am.stylish.app.common_presentation.ui.theme.ProductDescriptionTextStyle
import am.stylish.app.common_presentation.ui.theme.ProductDiscountTextStyle
import am.stylish.app.common_presentation.ui.theme.ProductOldPriceTextStyle
import am.stylish.app.common_presentation.ui.theme.ProductPriceTextStyle
import am.stylish.app.common_presentation.ui.theme.ProductReviewQuantityTextStyle
import am.stylish.app.common_presentation.ui.theme.ProductTitleTextStyle
import am.stylish.app.common_presentation.ui.theme.Shape10
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ProductGrid(products: List<Product>) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2), modifier = Modifier.padding(8.dp)
    ) {
        items(products) { product ->
            ProductCard(product)
        }
    }
}

@Composable
fun ProductCard(product: Product, onClick: () -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = Shape10,
        onClick = onClick
    ) {
        Column {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(Shape10),
                model = product.imageUrl,
                contentDescription = product.name,
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = product.name,
                    style = ProductTitleTextStyle,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.description,
                    style = ProductDescriptionTextStyle,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = stringResource(R.string.price, product.price),
                    style = ProductPriceTextStyle,
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    product.oldPrice?.let {
                        Text(
                            text = stringResource(R.string.old_price, it),
                            style = ProductOldPriceTextStyle,
                        )
                    }
                    product.discount?.let {
                        Text(
                            text = stringResource(R.string.off, it),
                            style = ProductDiscountTextStyle,
                        )
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    RatingBar(rating = product.rating)
                    product.reviewsCount?.let {
                        Text(
                            text = it.toString(),
                            style = ProductReviewQuantityTextStyle,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun RatingBar(rating: Float) {
    Row {
        repeat(5) { index ->
            Icon(
                modifier = Modifier.size(14.dp),
                imageVector = Icons.Filled.Star,
                contentDescription = "Star",
                tint = if (index < rating) Color(0xFFEDB310) else Color(0xFFBBBBBB)
            )
        }
    }
}

data class Product(
    val name: String,
    val description: String,
    val price: Int,
    val oldPrice: Int? = null,
    val discount: Int? = null,
    val rating: Float,
    val reviewsCount: Int? = null,
    val imageUrl: String
)

val sampleProducts = listOf(
    Product(
        name = "Black Winter HoodieBlack Winter Hoodie",
        description = "Autumn And Winter Casual Cotton-Padded Jacket",
        price = 499,
        oldPrice = 599,
        discount = 10,
        reviewsCount = 100_152_157,
        rating = 4.0f,
        imageUrl = "https://basket-15.wbbasket.ru/vol2300/part230005/230005258/images/big/1.webp"
    ), Product(
        name = "Men's Starry Shirt",
        description = "Men's Starry Sky Printed Shirt 100% Cotton Fabric",
        price = 399,
        rating = 4.5f,
        imageUrl = "https://basket-10.wbbasket.ru/vol1560/part156075/156075698/images/big/1.webp"
    ), Product(
        name = "Elegant Black Dress",
        description = "Beautiful sleeveless evening dress perfect for parties",
        price = 799,
        oldPrice = 599,
        discount = 10,
        reviewsCount = 100_152_157,
        rating = 4.7f,
        imageUrl = "https://basket-15.wbbasket.ru/vol2223/part222311/222311401/images/big/1.webp"
    ), Product(
        name = "Pink Embroidered Dress",
        description = "Casual pink dress with beautiful embroidery details",
        price = 699,
        rating = 4.2f,
        imageUrl = "https://images.pexels.com/photos/674010/pexels-photo-674010.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
    ), Product(
        name = "Casual Denim Jacket",
        description = "Classic blue denim jacket for all seasons",
        price = 599,
        rating = 4.1f,
        imageUrl = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg"
    ), Product(
        name = "Comfy Sneakers",
        description = "Lightweight and comfortable sneakers for daily wear",
        price = 499,
        oldPrice = 599,
        discount = 10,
        reviewsCount = 100_152_157,
        rating = 4.6f,
        imageUrl = "https://i0.wp.com/picjumbo.com/wp-content/uploads/amazing-stone-path-in-forest-free-image.jpg?w=600&quality=80"
    ), Product(
        name = "Trendy Sunglasses",
        description = "Stylish sunglasses with UV protection",
        price = 299,
        rating = 4.4f,
        imageUrl = "https://th.bing.com/th/id/OIG1.CgTbIrO0vUXLNU28HMdC"
    ), Product(
        name = "Smart Fitness Band",
        description = "Track your fitness with heart rate and sleep monitor",
        price = 999,
        rating = 4.3f,
        imageUrl = "https://picsum.photos/200/300"
    ), Product(
        name = "Leather Wallet",
        description = "High-quality leather wallet with multiple compartments",
        price = 349,
        oldPrice = 599,
        discount = 10,
        reviewsCount = 100_152_157,
        rating = 4.8f,
        imageUrl = "https://img.freepik.com/free-photo/colorful-design-with-spiral-design_188544-9588.jpg"
    ), Product(
        name = "Bluetooth Headphones",
        description = "Wireless headphones with noise-cancellation",
        price = 1299,
        oldPrice = 599,
        discount = 10,
        reviewsCount = 100_152_157,
        rating = 4.5f,
        imageUrl = "https://static.vecteezy.com/system/resources/thumbnails/009/273/280/small/concept-of-loneliness-and-disappointment-in-love-sad-man-sitting-element-of-the-picture-is-decorated-by-nasa-free-photo.jpg"
    )
)


@Preview
@Composable
private fun ProductListPrev() {
    ProductGrid(products = sampleProducts)
}