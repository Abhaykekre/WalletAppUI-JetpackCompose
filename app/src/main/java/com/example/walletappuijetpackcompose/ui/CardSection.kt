package com.example.walletappuijetpackcompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.walletappuijetpackcompose.R


@Preview
@Composable
fun CardSection(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(Color.Green, Color.Yellow)
                    )
                )
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .padding(horizontal = 22.dp, vertical = 10.dp),
            elevation = CardDefaults.cardElevation(6.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            CardContent(modifier = Modifier.fillMaxSize())
        }
    }
}

@Composable
fun CardContent(modifier: Modifier) {
    Box(
        modifier = modifier.background(
            brush = Brush.linearGradient(
                listOf(
                    MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.error
                )
            )
        )
    ) {
        Icon(
            painter = painterResource(id = R.drawable.world),
            contentDescription = "",
            tint = MaterialTheme.colorScheme.background.copy(0.1f),
            modifier = Modifier
                .fillMaxSize()
                .offset(150.dp, 80.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp)
                .align(Alignment.TopCenter),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "My balance",
                color = MaterialTheme.colorScheme.onPrimary.copy(0.6f),
                fontSize = 22.sp,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$4.235.56",
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 40.sp,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
        ) {
            Text(
                text = "* * * * 3466",
                color = MaterialTheme.colorScheme.onPrimary.copy(0.8f),
                fontSize = 23.sp
            )
            Icon(
                painter = painterResource(id = R.drawable.visa),
                contentDescription = "",
                modifier = Modifier.size(100.dp),
                tint = MaterialTheme.colorScheme.background
            )
        }
    }
}