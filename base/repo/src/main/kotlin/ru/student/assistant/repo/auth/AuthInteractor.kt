package ru.student.assistant.repo.auth

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import ru.student.assistant.core.contract.Auth

class AuthInteractor : Auth {

    private val auth = Firebase.auth

    override suspend fun signIn(email: String, pass: String): Boolean {

        var result = false
        auth.signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener { result = it.isSuccessful }
        return result
    }

    override suspend fun signUp(email: String, pass: String): Boolean {
        var result = false
        auth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener { result = it.isSuccessful }
        return result
    }

    override suspend fun isSigned(): Boolean {
        return auth.currentUser != null
    }

    override suspend fun restore(email: String): Boolean {
        auth.sendPasswordResetEmail(email)
        return true
    }

    override suspend fun signOut(): Boolean {
        auth.signOut()
        return true
    }

    companion object {
        private val instance: AuthInteractor? = AuthInteractor()
        fun getInstance(): AuthInteractor = instance ?: AuthInteractor()
    }
}
