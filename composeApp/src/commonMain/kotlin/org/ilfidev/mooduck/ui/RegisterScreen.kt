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
import org.ilfidev.mooduck.models.RegisterPageState
import org.ilfidev.mooduck.models.RegistrationScreenActions
import org.ilfidev.mooduck.models.RegistrationScreenState
import org.ilfidev.mooduck.util.Result
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
            onAuthUsernameChange = { newText ->
                viewModel.onAction(
                    RegistrationScreenActions.ChangeAuthUsernameText(
                        newText
                    )
                )

            },
            onAuthPasswordChange = { newText ->
                viewModel.onAction(
                    RegistrationScreenActions.ChangeAuthPasswordText(
                        newText
                    )
                )

            },
            onPageChange = { newPageState ->
                viewModel.onAction(
                    RegistrationScreenActions.PressPageButton(newPageState)
                )
            },
            onMainButtonClick = { viewModel.onAction(RegistrationScreenActions.PressRegisterButton) },
            onAuthClick = { viewModel.onAction(RegistrationScreenActions.PressLoginButton)}

        )

    }

}

@Composable
fun AuthThing(
    state: RegistrationScreenState,
    onUsernameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onAuthUsernameChange: (String) -> Unit,
    onAuthPasswordChange: (String) -> Unit,
    onPageChange: (RegisterPageState) -> Unit,
    onMainButtonClick: () -> Unit,
    onAuthClick: () -> Unit
) {
    Column(modifier = Modifier.size(597.dp, 597.dp)) {
        Row(modifier = Modifier.width(284.dp).weight(1f)) {
            DefaultButton("Sign up") { onPageChange(RegisterPageState.REGISTER) }
            DefaultButton("Log in") { onPageChange(RegisterPageState.LOGIN) }
        }
        if (state.page == RegisterPageState.REGISTER) {
            MainRegisterCard(state, onUsernameChange, onEmailChange, onPasswordChange, onMainButtonClick)
        } else {
            MainLoginCard(state = state, onUsernameChange = onAuthUsernameChange, onPasswordChange = onAuthPasswordChange, onMainButtonClick = onAuthClick)
        }
    }
}

@Composable
fun MainRegisterCard(
    state: RegistrationScreenState,
    onUsernameChange: (String) -> Unit = {},
    onEmailChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onMainButtonClick: () -> Unit
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
                onMainButtonClick()
            }) {
                Text("Sign up")
            }
        }
    }
}

@Composable
fun MainLoginCard(
    state: RegistrationScreenState,
    onUsernameChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onMainButtonClick: () -> Unit
) {
    Card(
        modifier = Modifier.size(597.dp, 547.dp),
        backgroundColor = Color(0xFFd8d8d8), shape = RectangleShape
    ) {
        Column(
            modifier = Modifier.padding(22.dp),
            verticalArrangement = Arrangement.spacedBy(34.dp)
        ) {
            LoginTextFields(state, onUsernameChange, onPasswordChange)
            Divider(modifier = Modifier.fillMaxWidth())
            Button(modifier = Modifier.fillMaxWidth(), onClick = {
                onMainButtonClick()
            }) {
                Text("Login")
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
        DefaultTextField(hint = "Username", text = state.signupUsername, onTextChange = onUsernameChange)
        DefaultTextField(hint = "Email", text = state.signupEmail, onTextChange = onEmailChange)
        DefaultTextField(hint = "Password", text = state.signupPassword, onTextChange = onPasswordChange)
        when (state.registerResult) {
            is Result.Success -> {
                if (state.registerResult.data != -1) {
                    Text("Вы успешно зарегистрировались!!!")
                }
            }

            is Result.Error -> Text("Произошла ошибка: ${state.registerResult.error.name}!")
        }
    }
}

@Composable
fun LoginTextFields(
    state: RegistrationScreenState,
    onAuthUsernameChange: (String) -> Unit,
    onAuthPasswordChange: (String) -> Unit,
) {
    DefaultTextField(hint = "Username", text = state.loginUsername, onTextChange = onAuthUsernameChange)
    DefaultTextField(hint = "Password", text = state.loginPassword, onTextChange = onAuthPasswordChange)
    when (state.authResult) {
        is Result.Success -> {
            if (state.authResult.data != "") {
                Text("Авторизация прошла успешно, переносим вас к доскам!!!")
                Text("${state.authResult.data}")
            }
        }

        is Result.Error -> Text("Произошла ошибка: ${state.registerResult}!")
    }
}
