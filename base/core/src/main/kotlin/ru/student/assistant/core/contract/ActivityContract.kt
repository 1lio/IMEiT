package ru.student.assistant.core.contract

import ru.student.assistant.core.AppConstants

interface ActivityContract {

    fun pushFragmentById(id: Byte, container:Int = AppConstants.CONTAINER_ID)

    fun removeFragmentById(id: Byte)
}