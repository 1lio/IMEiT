package ru.student.assistant.auth.gateway

import ru.student.core.entity.AuthData
import ru.student.core.entity.User

interface Account {

    // CRUD Account
    suspend fun createAccountEmail(authData: AuthData): Boolean

    suspend fun getAccount(uID: String): User

    suspend fun updateAccount(uID: String, user: User): Boolean

    suspend fun deleteAccountEmail(uID: String, email: String, pass: String): Boolean

}
