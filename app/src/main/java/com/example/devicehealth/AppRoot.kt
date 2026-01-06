package com.example.devicehealth.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.devicehealth.data.local.User
import com.example.devicehealth.ui.auth.AuthScreen
import com.example.devicehealth.ui.auth.AuthViewModel
import com.example.devicehealth.ui.home.HomeScreen
import com.example.devicehealth.ui.splash.SplashScreen
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

@Composable
fun AppRoot() {
    val viewModel: AuthViewModel = viewModel()

    val auth = FirebaseAuth.getInstance()
    var loggedInUser by remember { mutableStateOf<User?>(null) }
    var showSplash by remember { mutableStateOf(true) }

    // This state track if we've checked for a logged in user
    var isAuthChecked by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        // Minimum splash duration
        delay(1500) 
        
        val firebaseUser = auth.currentUser
        if (firebaseUser != null) {
            val localUser = viewModel.getLocalUser(firebaseUser.uid)
            loggedInUser = localUser
        }
        
        isAuthChecked = true
        showSplash = false
    }

    if (showSplash) {
        SplashScreen()
    } else if (isAuthChecked) {
        if (loggedInUser == null) {
            AuthScreen(onAuthSuccess = { loggedInUser = it })
        } else {
            HomeScreen(
                user = loggedInUser!!,
                onLogout = {
                    viewModel.logout()
                    loggedInUser = null
                }
            )
        }
    }
}