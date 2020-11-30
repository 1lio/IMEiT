package ru.assistant.core.contract

import ru.assistant.core.AppConstants

interface AppNavigation {

    fun pushFragmentById(id: Byte, container: Int = AppConstants.CONTAINER_ID, now: Boolean = false)

    fun removeFragmentById(id: Byte)

    fun showLoader(isShow: Boolean, message: String = "${0x2026.toChar()}")

}