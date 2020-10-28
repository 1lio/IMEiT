package ru.student.assistant.repo

import com.google.firebase.database.FirebaseDatabase
import ru.student.assistant.repo.account.AccountInteractor
import ru.student.assistant.repo.calls.CallsInteractor
import ru.student.assistant.repo.chat.ChatInteractor
import ru.student.assistant.repo.maps.MapsInteractor
import ru.student.assistant.repo.schedule.ScheduleInteractor

class FirebaseRepository : Repository {

    private val instance: FirebaseRepository? = null
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()

    override fun getAccountInteractor(): AccountInteractor {
        TODO("Not yet implemented")
    }

    override fun getScheduleInteractor(): ScheduleInteractor {
        TODO("Not yet implemented")
    }

    override fun getCallsInteractor(): CallsInteractor {
        TODO("Not yet implemented")
    }

    override fun getMapsInteractor(): MapsInteractor {
        TODO("Not yet implemented")
    }

    override fun getChatInteractor(): ChatInteractor {
        TODO("Not yet implemented")
    }

    fun getInstance() = this.instance ?: FirebaseRepository()

}
