package ru.student.core.base

interface ActivityContract {

    fun pushFragmentById(id: Byte)

    fun removeFragmentById(id: Byte)
}