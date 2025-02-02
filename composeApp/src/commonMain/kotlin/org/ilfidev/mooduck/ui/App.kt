package org.ilfidev.mooduck.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.jetbrains.compose.ui.tooling.preview.Preview

import org.ilfidev.mooduck.Greeting
import org.ilfidev.mooduck.MoodBoardsScreen
import org.ilfidev.mooduck.RegistrationScreen
import org.ilfidev.mooduck.viewmodel.RegistrationViewModel
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        KoinContext {
            NavHost(
                navController = navController,
                startDestination = RegistrationScreen
            ) {
                composable<RegistrationScreen> {
                    RegisterScreen(navController = navController)
                }
//                composable(route = "home") {
//                    val viewModel = koinViewModel<RegistrationViewModel>()
//                    RegisterScreen()
//                }
                composable<MoodBoardsScreen> {
                    val args = it.toRoute<MoodBoardsScreen>()
                    MoodBoardsScreen()
                }
            }
        }
//        var showContent by remember { mutableStateOf(false) }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            val greeting = remember { Greeting().greet() }
//            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
////                MainScreen()
////                RegisterScreen()
//            }
//        }
    }
}


