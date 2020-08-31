package ru.student.core.base

import ru.student.core.AppConstants

interface ActivityContract {

    fun pushFragmentById(id: Byte, container:Int = AppConstants.CONTAINER_ID)

    fun removeFragmentById(id: Byte)
}