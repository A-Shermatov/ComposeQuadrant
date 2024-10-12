package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ComposeQuadrantsCard()
                }
            }
        }
    }
}


@Composable
fun ComposeQuadrantsCard() {
    QuadrantsCard(
        firstCardTitle = stringResource(R.string.first_title_text),
        firstCardContent = stringResource(R.string.first_description_text),
        firstCardBackgroundColor = Color(0xFFEADDFF),

        secondCardTitle = stringResource(R.string.second_title_text),
        secondCardContent = stringResource(R.string.second_description_text),
        secondCardBackgroundColor = Color(0xFFB69DF8),

        thirdCardTitle = stringResource(R.string.third_title_text),
        thirdCardContent = stringResource(R.string.third_description_text),
        thirdCardBackgroundColor = Color(0xFFD0BCFF),

        fourthCardTitle = stringResource(R.string.fourth_title_text),
        fourthCardContent = stringResource(R.string.fourth_description_text),
        fourthCardBackgroundColor = Color(0xFFF6EDFF),
    )
}
@Composable
private fun QuadrantsCard(
    firstCardTitle: String,
    firstCardContent: String,
    firstCardBackgroundColor: Color,

    secondCardTitle: String,
    secondCardContent: String,
    secondCardBackgroundColor: Color,

    thirdCardTitle: String,
    thirdCardContent: String,
    thirdCardBackgroundColor: Color,

    fourthCardTitle: String,
    fourthCardContent: String,
    fourthCardBackgroundColor: Color,
) {
    Row(modifier = Modifier.fillMaxHeight()) {
        Column(modifier = Modifier.weight(1f)) {
            QuadrantCard(
                title = firstCardTitle,
                content = firstCardContent,
                backgroundColor = firstCardBackgroundColor,
                modifier = Modifier.weight(1f),
            )
            QuadrantCard(
                title = secondCardTitle,
                content = secondCardContent,
                backgroundColor = secondCardBackgroundColor,
                modifier = Modifier.weight(1f),
            )
        }
        Column(modifier = Modifier.weight(1f)) {
            QuadrantCard(
                title = thirdCardTitle,
                content = thirdCardContent,
                backgroundColor = thirdCardBackgroundColor,
                modifier = Modifier.weight(1f),
            )
            QuadrantCard(
                title = fourthCardTitle,
                content = fourthCardContent,
                backgroundColor = fourthCardBackgroundColor,
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Composable
private fun QuadrantCard (
    title: String,
    content: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun ComposeQuadrantPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrantsCard()
    }
}