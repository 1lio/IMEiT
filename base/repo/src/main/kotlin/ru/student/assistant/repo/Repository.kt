package ru.student.assistant.repo

import ru.student.assistant.repo.account.AccountInteractor
import ru.student.assistant.repo.calls.CallsInteractor
import ru.student.assistant.repo.chat.ChatInteractor
import ru.student.assistant.repo.maps.MapsInteractor
import ru.student.assistant.repo.schedule.ScheduleInteractor

interface Repository {

    fun getAccountInteractor(): AccountInteractor

    fun getScheduleInteractor(): ScheduleInteractor

    fun getCallsInteractor(): CallsInteractor

    fun getMapsInteractor(): MapsInteractor

    fun getChatInteractor(): ChatInteractor

}