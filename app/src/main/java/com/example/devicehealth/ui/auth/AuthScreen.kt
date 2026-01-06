package com.example.devicehealth.ui.auth

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
<<<<<<< HEAD
=======
import androidx.compose.ui.graphics.Color
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
<<<<<<< HEAD
import androidx.compose.ui.tooling.preview.Preview
=======
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.devicehealth.R
import com.example.devicehealth.data.local.User
<<<<<<< HEAD
import com.example.devicehealth.ui.theme.DeviceHealthTheme
=======
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51

@Composable
fun AuthScreen(
    onAuthSuccess: (User) -> Unit,
    viewModel: AuthViewModel = viewModel()
) {
<<<<<<< HEAD
    val message by viewModel.authMessage
    AuthContent(
        authMessage = message,
        onLogin = { email, password -> viewModel.login(email, password, onAuthSuccess) },
        onRegister = { email, password -> viewModel.register(email, password, onAuthSuccess) }
    )
}

@Composable
fun AuthContent(
    authMessage: String?,
    onLogin: (String, String) -> Unit,
    onRegister: (String, String) -> Unit
) {
=======
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51
    var isSignUp by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }
<<<<<<< HEAD
=======
    val message by viewModel.authMessage
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51

    fun validate(): Boolean {
        if (email.isBlank() || password.isBlank()) {
            error = "Email and password cannot be empty."
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            error = "Invalid email format."
            return false
        }
        if (password.length < 6) {
            error = "Password must be at least 6 characters."
            return false
        }
        if (isSignUp && password != confirmPassword) {
            error = "Passwords do not match."
            return false
        }
        return true
    }

    val neonGreen = MaterialTheme.colorScheme.primary
    val background = MaterialTheme.colorScheme.background
    val textColor = MaterialTheme.colorScheme.onBackground
    val onPrimary = MaterialTheme.colorScheme.onPrimary

    Surface(
<<<<<<< HEAD
        modifier = Modifier.fillMaxSize(),
=======
        modifier = Modifier
            .fillMaxSize(),
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51
        color = background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

<<<<<<< HEAD
=======
            // Logo (optional)
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51
            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = stringResource(id = R.string.app_name),
                modifier = Modifier
                    .size(90.dp)
                    .padding(bottom = 12.dp)
            )

<<<<<<< HEAD
=======
            // App name - dynamic
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.titleLarge.copy(
                    color = neonGreen,
                    fontSize = 26.sp
                ),
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(32.dp))

<<<<<<< HEAD
=======
            // Boxy form area
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, neonGreen, RoundedCornerShape(4.dp))
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = if (isSignUp) "CREATE ACCOUNT" else "LOGIN",
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = neonGreen
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

<<<<<<< HEAD
=======
                // --- Email field (no outlinedTextFieldColors used) ---
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email", color = neonGreen) },
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyLarge.copy(color = textColor),
<<<<<<< HEAD
=======
                    // rely on theme primary for focused border color
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(12.dp))

<<<<<<< HEAD
=======
                // --- Password field ---
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password", color = neonGreen) },
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
                    textStyle = MaterialTheme.typography.bodyLarge.copy(color = textColor),
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier.fillMaxWidth()
                )

                if (isSignUp) {
                    Spacer(Modifier.height(12.dp))
                    OutlinedTextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        label = { Text("Confirm Password", color = neonGreen) },
                        singleLine = true,
                        visualTransformation = PasswordVisualTransformation(),
                        textStyle = MaterialTheme.typography.bodyLarge.copy(color = textColor),
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Spacer(Modifier.height(20.dp))

<<<<<<< HEAD
=======
                // Flat neon button
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51
                Button(
                    onClick = {
                        error = null
                        if (!validate()) return@Button
                        if (isSignUp) {
<<<<<<< HEAD
                            onRegister(email, password)
                        } else {
                            onLogin(email, password)
=======
                            viewModel.register(email, password)
                        } else {
                            viewModel.login(email, password) { user ->
                                onAuthSuccess(user)
                            }
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = neonGreen,
                        contentColor = onPrimary
                    ),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(
                        text = if (isSignUp) "ENTER" else "ACCESS",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = onPrimary,
                            fontSize = 16.sp
                        )
                    )
                }

                Spacer(Modifier.height(12.dp))

                TextButton(onClick = {
                    isSignUp = !isSignUp
                    error = null
                }) {
                    Text(
                        if (isSignUp) "Already registered? Access system"
                        else "New user? Create account",
                        color = neonGreen,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                error?.let {
                    Spacer(Modifier.height(8.dp))
                    Text(
                        it,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }

<<<<<<< HEAD
                authMessage?.let {
=======
                message?.let {
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51
                    Spacer(Modifier.height(8.dp))
                    Text(
                        it,
                        color = neonGreen.copy(alpha = 0.7f),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
<<<<<<< HEAD

@Preview(showBackground = true)
@Composable
fun AuthScreenPreview() {
    DeviceHealthTheme {
        AuthContent(
            authMessage = "Preview Mode",
            onLogin = { _, _ -> },
            onRegister = { _, _ -> }
        )
    }
}
=======
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51
