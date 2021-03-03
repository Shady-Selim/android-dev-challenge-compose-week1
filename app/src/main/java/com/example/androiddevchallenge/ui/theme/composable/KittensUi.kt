package com.example.androiddevchallenge.ui.theme.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Cat
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun KittensUi(
    kitten: Cat?,
    onClick: () -> Unit
) {
    Card(
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier
            .padding(16.dp, 8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(onClick = onClick)

    ) {
        Row(
            Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(kitten?.image!!),
                contentDescription = null,
                modifier = Modifier
                    .height(120.dp)
                    .width(200.dp)
                    .clip(shape = shapes.medium),
                contentScale = ContentScale.None
            )
            Spacer(
                modifier = Modifier.width(8.dp)
            )
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = kitten.name,
                    style = typography.h4
                )
                Text(
                    text = "${kitten.age} months",
                    style = typography.subtitle1
                )
                Text(
                    text = kitten.type,
                    style = typography.subtitle2
                )
            }
        }
    }
}