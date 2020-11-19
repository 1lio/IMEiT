package ru.assistant.core.contract

interface Auth {

    suspend fun signIn(email: String, pass: String): Boolean

    suspend fun signUp(email: String, pass: String): Boolean

    suspend fun isSigned(): Boolean

    suspend fun restore(email: String): Boolean

    suspend fun signOut(): Boolean

}
