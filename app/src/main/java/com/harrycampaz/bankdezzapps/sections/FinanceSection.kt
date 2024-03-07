package com.harrycampaz.bankdezzapps.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.Money
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harrycampaz.bankdezzapps.ui.theme.BlueEnd
import com.harrycampaz.bankdezzapps.ui.theme.OrangeStart

val finances = listOf(
    Finance(
        icon = Icons.Rounded.Star,
        name = "My Investments",
        background = Color(0xFFD0BCFF),
    ),
    Finance(
        icon = Icons.Rounded.Money,
        name = "My Loans",
        background = OrangeStart,
    ),
    Finance(
        icon = Icons.Rounded.MonetizationOn,
        name = "My Savings",
        background = BlueEnd,
    )
)

@Preview
@Composable
fun FinanceSection() {

    Column {
        Text(
            text = "Finance",
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        LazyRow {
            items(finances.size) { index ->
                FinanceItem(index)
            }
        }
    }
}

@Composable
fun FinanceItem(index: Int) {
    val finance = finances[index]
    var lastPaddingEnd = 0.dp
    if (index == finances.size - 1) {
        lastPaddingEnd = 16.dp
    }
    Box(modifier = Modifier.padding(start = 16.dp, end = lastPaddingEnd))

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .size(120.dp)
            .clickable { }
            .padding(13.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(finance.background)
                .padding(6.dp)
        )
        {
            Icon(
                imageVector = finance.icon,
                contentDescription = finance.name,
                tint = MaterialTheme.colorScheme.onBackground
            )

        }

        Text(
            text = finance.name,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

data class Finance(
    val icon: ImageVector,
    val name: String,
    val background: Color,
)