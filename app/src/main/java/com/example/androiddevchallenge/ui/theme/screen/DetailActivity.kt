package com.example.androiddevchallenge.ui.theme.screen

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Cat
import com.example.androiddevchallenge.data.KittensData
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.composable.KittensUi
import com.example.androiddevchallenge.ui.theme.typography

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cat: Cat? = intent.getParcelableExtra("cat")
        setContent {
            MyTheme {
                KittenDetails(cat)
            }
        }
    }
}

@Composable
fun KittenDetails(cat: Cat?) {
    Column(
        modifier = Modifier.background(Color.Gray)
    ) {
        MyHeader(cat)
        KittensUi(cat) { /* Do something */ }
        Button(
            onClick = { /* Do something */ },
            Modifier
                .padding(16.dp)
                .fillMaxWidth()

        ) {
            Text("Adopt ${cat?.name} Now!")
        }
        Spacer(modifier = Modifier.fillMaxHeight())
    }
}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        KittenDetails(KittensData.KittensList[0])
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        KittenDetails(KittensData.KittensList[0])
    }
}

@Composable
fun MyHeader(cat: Cat?) {
    Card(
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "${cat?.name} is waiting for you",
                style = typography.h4
            )
            Text(
                text = "${cat?.name} story:",
                style = typography.h6,
                modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp)
            )
            Text(
                text = cat?.details.toString()
            )
        }
    }
}