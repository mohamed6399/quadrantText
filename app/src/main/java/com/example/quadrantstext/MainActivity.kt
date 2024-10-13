package com.example.quadrantstext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quadrantstext.ui.theme.QuadrantsTextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuadrantsTextTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuadrantsScreen()
                }
            }
        }
    }
}

@Composable
fun QuadrantsScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.weight(1f)) {
            Quadrant(
                title = "Text composables",
                description = "Display text and follows the recommended Material Design guidelines.",
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f).fillMaxHeight()
            )
            Quadrant(
                title = "Image composables",
                description = "Create a composable that lays out and draws a given Painter class object.",
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f).fillMaxHeight()
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            Quadrant(
                title = "Row composables",
                description = "A layout composable that places its children in a horizontal sequence.",
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f).fillMaxHeight()
            )
            Quadrant(
                title = "Column composables",
                description = "A layout composable that places its children in a vertical sequence.",
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f).fillMaxHeight()
            )
        }
    }
}

@Composable
fun Quadrant(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentAlignment = Alignment.Center // Centre tout le contenu
    ) {
        Column(
            horizontalAlignment = Alignment.Start, // Aligner à gauche dans chaque quadrant
            verticalArrangement = Arrangement.Center // Centre verticalement
        ) {
            LabeledText(label = "", text = title, isBold = true) // Titre avec puce
            Spacer(modifier = Modifier.height(8.dp)) // Espacement entre le titre et la description
            LabeledText(label = "", text = description) // Description avec puce
        }
    }
}

@Composable
fun LabeledText(label: String, text: String, isBold: Boolean = false) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 8.dp) // Léger espacement horizontal
    ) {
        Text(text = label, fontWeight = FontWeight.Bold) // Marque de début
        Spacer(modifier = Modifier.width(4.dp)) // Espacement entre la marque et le texte
        Text(
            text = text,
            fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantsScreenPreview() {
    QuadrantsTextTheme {
        QuadrantsScreen()
    }
}
