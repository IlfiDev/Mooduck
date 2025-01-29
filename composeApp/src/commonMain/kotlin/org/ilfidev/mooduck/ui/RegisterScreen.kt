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
import androidx.lifecycle.viewmodel.compose.viewModel
import org.ilfidev.mooduck.models.RegistrationScreenActions
import org.ilfidev.mooduck.models.RegistrationScreenState
import org.ilfidev.mooduck.models.UserReg
import org.ilfidev.mooduck.viewmodel.RegistrationViewModel
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun RegisterScreen() {
    val viewModel = koinViewModel<RegistrationViewModel>()
    val state = viewModel.state.collectAsState()
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        MainActivityTopBar("MOODUCK", {}, {})
        AuthThing(state.value,
            onUsernameChange = { newText ->
                viewModel.onAction(
                    RegistrationScreenActions.ChangeUsernameText(
                        newText
                    )
                )
            },
            onEmailChange = { newText ->
                viewModel.onAction(
                    RegistrationScreenActions.ChangeEmailText(
                        newText
                    )
                )
            },
            onPasswordChange = { newText ->
                viewModel.onAction(
                    RegistrationScreenActions.ChangePasswordText(
                        newText
                    )
                )
            },
            onRegisterClick = { viewModel.registerUser() })
    }

}

@Composable
fun AuthThing(
    state: RegistrationScreenState,
    onUsernameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onRegisterClick: () -> Unit
) {
    Column(modifier = Modifier.size(597.dp, 597.dp)) {
        Row(modifier = Modifier.width(284.dp).weight(1f)) {
            DefaultButton("Sign up", {})
            DefaultButton("Log in", {})
        }
        MainCard(state, onUsernameChange, onEmailChange, onPasswordChange, onRegisterClick)
    }
}

@Composable
fun MainCard(
    state: RegistrationScreenState,
    onUsernameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onRegisterClick: () -> Unit
) {
    Card(
        modifier = Modifier.size(597.dp, 547.dp),
        backgroundColor = Color(0xFFd8d8d8), shape = RectangleShape
    ) {
        Column(
            modifier = Modifier.padding(22.dp),
            verticalArrangement = Arrangement.spacedBy(34.dp)
        ) {
            SignUpTextFields(state, onUsernameChange, onEmailChange, onPasswordChange)
            Divider(modifier = Modifier.fillMaxWidth())
            Button(modifier = Modifier.fillMaxWidth(), onClick = {
                onRegisterClick()
            }) {
                Text("Sign up")
            }
        }
    }
}

@Composable
fun SignUpTextFields(
    state: RegistrationScreenState,
    onUsernameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(34.dp)) {
        DefaultTextField(hint = "Username", text = state.username, onTextChange = onUsernameChange)
        DefaultTextField(hint = "Email", text = state.email, onTextChange = onEmailChange)
        DefaultTextField(hint = "Password", text = state.password, onTextChange = onPasswordChange)
    }
}
