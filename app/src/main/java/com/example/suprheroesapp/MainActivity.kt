package com.example.suprheroesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.suprheroesapp.ui.theme.SuprheroesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuprheroesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SuperheroApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun SuperheroAppPreview() {
    SuprheroesAppTheme(darkTheme = false) {
        SuperheroApp()
    }
}

@Preview
@Composable
fun SuperheroAppDarkThemePreview() {
    SuprheroesAppTheme(darkTheme = true) {
        SuperheroApp()
    }
}