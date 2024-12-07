package am.stylish.app.common_presentation.components.address

import am.stylish.app.R
import am.stylish.app.common_presentation.ui.theme.AddressTitleTextStyle
import am.stylish.app.common_presentation.ui.theme.AppSubtitleTextStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddressSection(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .weight(1f)
                .height(80.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .height(80.dp),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(R.string.address),
                        style = AppSubtitleTextStyle
                    )
                    Icon(
                        painter = painterResource(R.drawable.ic_edit_address),
                        contentDescription = stringResource(R.string.edit_address),
                        modifier = Modifier.size(12.dp)
                    )
                }

                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = stringResource(R.string.test_address),
                    style = AddressTitleTextStyle
                )
            }
        }

        Card(
            modifier = Modifier
                .size(80.dp)
                .fillMaxHeight()
                .padding(start = 8.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {

                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.address),
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        }
    }
}


@Preview
@Composable
private fun AddressSectionPrev() {
    AddressSection(Modifier.fillMaxWidth())
}