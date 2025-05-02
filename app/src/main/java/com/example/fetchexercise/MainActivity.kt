package com.example.fetchexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import com.example.fetchexercise.ui.main.MainScreen
import com.example.fetchexercise.ui.main.MainViewModel
import com.example.fetchexercise.ui.theme.FetchExerciseTheme

class MainActivity : ComponentActivity() {

    // Initialize MainViewModel
    private val mainViewModel: MainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FetchExerciseTheme {
                Surface {
                    mainViewModel.loadData()
                    val state = mainViewModel.state.collectAsState()
                    MainScreen(state.value)
                }
            }
        }
    }
}