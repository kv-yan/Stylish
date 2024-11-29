package am.stylish.app.common_presentation.components.action_bar

import am.stylish.app.R
import am.stylish.app.common_presentation.components.button.IconTextButton
import am.stylish.app.common_presentation.ui.theme.AuthTitleTextStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemsSummaryHeaderWithActions(
    modifier: Modifier = Modifier,
    title: String = "",
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = title,
            style = AuthTitleTextStyle,
            fontSize = 20.sp,
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            IconTextButton(
                padding = PaddingValues(
                    horizontal = 8.dp,
                    vertical = 4.dp,
                ),
                text = stringResource(R.string.sort),
                icon = R.drawable.ic_sort,
            )
            IconTextButton(
                padding = PaddingValues(
                    horizontal = 8.dp,
                    vertical = 4.dp,
                ),
                text = stringResource(R.string.filter),
                icon = R.drawable.ic_filter,
            )
        }
    }
}