package ru.assistant.core

object AppConstants {

    const val CONTAINER_ID: Int = 1
    const val FRAGMENT_AUTH: Byte = 1

    const val FRAGMENT_SIGN_IN: Byte = 11
    const val FRAGMENT_SIGN_UP: Byte = 12
    const val FRAGMENT_RESTORE: Byte = 13

    const val FRAGMENT_ACCOUNT: Byte = 2
    const val FRAGMENT_EMPTY_SCHEDULE: Byte = 3
    const val FRAGMENT_SCHEDULE: Byte = 4
    const val FRAGMENT_CALLS: Byte = 5
    const val FRAGMENT_CALLS_PREF: Byte = 6
    const val FRAGMENT_MAPS: Byte = 7

    const val FRAGMENT_CHAT: Byte = 8

    const val DIALOG_GROUP: Byte = 10
    const val DIALOG_EXIT: Byte = 127

    const val LOG_DEBUG = "LOG_DEBUG_APP"
    const val LOG_ACCOUNT = "LOG_DEBUG_ACCOUNT"
    const val LOG_CALLS = "LOG_DEBUG_CALLS"
    const val LOG_BUILDINGS = "LOG_BUILDINGS"
}