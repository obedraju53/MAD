package com.example.devicehealth.ui.auth

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.devicehealth.data.local.User
import com.example.devicehealth.data.local.UserDatabase
import com.example.devicehealth.data.repository.UserRepository
import kotlinx.coroutines.launch
import com.google.firebase.auth.FirebaseAuth
<<<<<<< HEAD
=======
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51

class AuthViewModel(application: Application) : AndroidViewModel(application) {

    private val auth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    private val userDao = UserDatabase.getDatabase(application).userDao()
    private val repository = UserRepository(userDao)

    var authMessage = mutableStateOf<String?>(null)

<<<<<<< HEAD
    fun register(email: String, password: String, onSuccess: (User) -> Unit) {
=======
    fun register(email: String, password: String) {
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val uid = auth.currentUser!!.uid
                    viewModelScope.launch {
<<<<<<< HEAD
                        val user = User(firebaseUid = uid, email = email)
                        repository.saveFirebaseUser(uid, email)
                        authMessage.value = "Account created successfully!"
                        onSuccess(user)
=======
                        repository.saveFirebaseUser(uid, email)
                        authMessage.value = "Account created successfully!"
>>>>>>> 04e30d32b4066876e58de37f6881e79e69005b51
                    }
                } else {
                    authMessage.value = task.exception?.message ?: "Registration failed."
                }
            }
    }

    fun login(email: String, password: String, onSuccess: (User) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val firebaseUser = auth.currentUser!!
                    viewModelScope.launch {
                        val local = repository.getLocalUser(firebaseUser.uid)
                        if (local != null) {
                            onSuccess(local)
                        } else {
                            val newLocal = User(firebaseUid = firebaseUser.uid, email = firebaseUser.email ?: email)
                            repository.saveFirebaseUser(firebaseUser.uid, newLocal.email)
                            onSuccess(newLocal)
                        }
                    }
                } else {
                    authMessage.value = "Invalid email or password."
                }
            }
    }

    fun logout() {
        auth.signOut()
    }
    suspend fun getLocalUser(uid: String): User? {
        return repository.getLocalUser(uid)
    }

}
