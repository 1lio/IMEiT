package ru.student.assistant.auth.gateway

interface Auth {

    suspend fun signIn(email: String, pass: String): Boolean

    suspend fun signOut(): Boolean

    suspend fun isSigned(): Boolean

    suspend fun restore(email: String)

    fun getCurrentUserID(): String?

}