package ru.vyaacheslav.suhov.imeit.entity

/** Данные для создания аккаунта
 *  @param email - Email
 *  @param pass - Пароль
 *  @param user - Пользовательские данные
 */

data class AuthData(var email: String = "",
                    var pass: String = "",
                    var user: User = User())