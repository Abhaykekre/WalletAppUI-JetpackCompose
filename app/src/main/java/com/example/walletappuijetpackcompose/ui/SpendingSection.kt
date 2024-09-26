package com.example.walletappuijetpackcompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.walletappuijetpackcompose.R
import com.example.walletappuijetpackcompose.randomColor


@Composable
fun SpendingSection(modifier: Modifier) {
    Text(
        modifier = Modifier.padding(horizontal = 22.dp),
        text = "Spending Breakdown",
        fontSize = 25.sp,
    )
    Spacer(modifier = Modifier.height(16.dp))

    SpendingList()
}

@Preview
@Composable
fun SpendingList(modifier: Modifier = Modifier) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
          items(spendingItems){
              SpendingItem(spendingItem = it)
              Spacer(modifier = Modifier.width(16.dp))
          }
    }
}

@Composable
fun SpendingItem(
    modifier: Modifier = Modifier,
    spendingItem: SpendingItem
) {
    ElevatedCard(
        modifier = Modifier.size(150.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .background(spendingItem.color.copy(0.5f))
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = spendingItem.icon),
                contentDescription = "",
                tint = Color.Black.copy(0.8f),
                modifier = Modifier.size(33.dp)
            )

                Text(
                    text = spendingItem.name,
                    fontSize = 15.sp,
                    color = Color.Black.copy(0.7f)
                )

                Text(
                    text = "$" + spendingItem.amount.toString(),
                    fontSize = 20.sp,
                    color = Color.Black
                )

        }
    }
}

val spendingItems = listOf(
    SpendingItem(
        name = "Food",
        amount = 123f,
        color = randomColor(),
        icon = R.drawable.restaurant,
    ),
    SpendingItem(
        name = "Shopping",
        amount = 166f,
        color = randomColor(),
        icon = R.drawable.shopping
    ),
    SpendingItem(
        name = "Subscription",
        amount = 84f,
        color = randomColor(),
        icon = R.drawable.subscriptions
    ),
    SpendingItem(
        name = "Health",
        amount = 140f,
        color = randomColor(),
        icon = R.drawable.directions_walk
    ),
)

data class SpendingItem(
    val name: String,
    val amount: Float,
    val color: Color,
    val icon: Int,
)