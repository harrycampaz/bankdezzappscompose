package com.harrycampaz.bankdezzapps.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.harrycampaz.bankdezzapps.R
import com.harrycampaz.bankdezzapps.ui.theme.OrangeEnd
import com.harrycampaz.bankdezzapps.ui.theme.OrangeStart
import com.harrycampaz.bankdezzapps.ui.theme.PurpleEnd
import com.harrycampaz.bankdezzapps.ui.theme.PurpleStart


data class Card(
    val cardType: String,
    val cardNumber: String,
    val cardTitle: String,
    val balance: Double,
    val color: Brush
)


val cardsItemsMocks = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "**** **** 8987",
        cardTitle = "Personal",
        balance = 1000.00,
        color = gradientColor(
            colorStart = PurpleStart,
            colorEnd = PurpleEnd
        )

    ),

    Card(
        cardType = "MasterCard",
        cardNumber = "**** **** 1234",
        cardTitle = "Business",
        balance = 2.000,
        color = gradientColor(
            colorStart = OrangeStart,
            colorEnd = OrangeEnd
        )
    ),
    Card(
        cardType = "MasterCard",
        cardNumber = "**** **** 5456",
        cardTitle = "Personal",
        balance = 2999.0,
        color = gradientColor(
            colorStart = OrangeStart,
            colorEnd = OrangeEnd
        )
    ),
    Card(
        cardType = "VISA",
        cardNumber = "**** **** 8765",
        cardTitle = "Saving",
        balance = 10440.00,
        color = gradientColor(
            colorStart = PurpleStart,
            colorEnd = PurpleEnd
        )

    ),
)

fun gradientColor(colorStart: Color, colorEnd: Color) = Brush.horizontalGradient(
    colors = listOf(
        colorStart,
        colorEnd
    )
)


@Preview
@Composable
fun CardSection(
    cards: List<Card> = cardsItemsMocks
) {

    LazyRow {
        items(count = cards.size) { index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(index: Int) {

    val card = cardsItemsMocks[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cardsItemsMocks.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.ic_visa)

    if (card.cardType == "MasterCard") {
        image = painterResource(id = R.drawable.ic_mastercard)
    }

    Box(modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)) {

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .padding(vertical = 12.dp, horizontal = 16.dp)
                .clickable { },
            verticalArrangement = Arrangement.SpaceBetween
        ) {


            Image(
                modifier = Modifier.width(60.dp),
                painter = image, contentDescription = card.cardTitle
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = card.cardTitle, color = Color.White, fontWeight = FontWeight.Bold)
            Text(text = "$ ${card.balance}", color = Color.White, fontWeight = FontWeight.Bold)
            Text(text = card.cardNumber, color = Color.White, fontWeight = FontWeight.Bold)
        }

    }


}
