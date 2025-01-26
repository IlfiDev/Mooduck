package org.ilfidev.mooduck.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import org.ilfidev.mooduck.models.UserReg
import org.ilfidev.mooduck.viewmodel.RegistrationViewModel
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun RegisterScreen() {
    val viewModel = koinViewModel<RegistrationViewModel>()
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        MainActivityTopBar("MOODUCK", {}, {})
        AuthThing(viewModel)
    }

}

@Composable
fun AuthThing(viewModel: RegistrationViewModel) {
    Column(modifier = Modifier.size(597.dp, 597.dp)) {
        Row(modifier = Modifier.width(284.dp).weight(1f)) {
            DefaultButton("Sign up", {viewModel.registerUser(UserReg("emil", "emil@gays.com", "sosal chlen", "emil", "prostouebaXDDDDDD"))})
            DefaultButton("Log in", {})
        }
        MainCard()
    }
}

@Composable
fun MainCard() {
    Card(
        modifier = Modifier.size(597.dp, 547.dp),
        backgroundColor = Color(0xFFd8d8d8), shape = RectangleShape
    ) {
        Column(modifier = Modifier.padding(22.dp), verticalArrangement = Arrangement.spacedBy(34.dp)) {

            SignUpTextFields()
            Divider(modifier = Modifier.fillMaxWidth())
            Button(modifier = Modifier.fillMaxWidth(), onClick = {}) {
                Text("Sign up")
            }
        }
    }
}

@Composable
fun SignUpTextFields() {
    var usernameField by remember { mutableStateOf("") }
    var emailField by remember { mutableStateOf("") }
    var passwordField by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(34.dp)) {
        DefaultTextField(value = usernameField)
        DefaultTextField(value = emailField)
        DefaultTextField(value = passwordField)
    }
}
