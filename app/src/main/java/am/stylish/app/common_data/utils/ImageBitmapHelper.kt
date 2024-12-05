package am.stylish.app.common_data.utils

import android.content.Context
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult


suspend fun getBitmapFromUrl(context: Context, url: String): ImageBitmap? {
    val imageLoader = ImageLoader(context)
    val request = ImageRequest.Builder(context)
        .data(url)
        .build()

    return try {
        val result = (imageLoader.execute(request) as? SuccessResult)?.drawable
        (result as? android.graphics.drawable.BitmapDrawable)?.bitmap?.asImageBitmap()
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}
