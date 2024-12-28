package am.stylish.app.common_presentation.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun NetworkImage(
    modifier: Modifier = Modifier,
    url: String,
    contentDescription: String? = null,
    shape: RoundedCornerShape = RoundedCornerShape(0),
    scale: ContentScale = ContentScale.Fit,
) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(url).crossfade(true).build()
    )

    Image(
        modifier = modifier.clip(shape),
        painter = painter,
        contentDescription = contentDescription,
        contentScale = scale
    )

}