package com.example.pubgstatmob.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pubgstatmob.MainApp
import com.example.pubgstatmob.presentation.StatViewModel
import com.example.pubgstatmob.ui.theme.PubgStatMobTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var statViewModel: StatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MainApp.applicationComponent.activityViewModelComponentBuilder()
            .componentActivity(this)
            .build()
            .inject(this)

        statViewModel.getPlayerStat()

        setContent {
            PubgStatMobTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PubgStatMobTheme {
        Greeting("Android")
    }
}