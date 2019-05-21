package ru.vyaacheslav.suhov.imeit.repository

import com.orhanobut.hawk.Hawk
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import ru.vyaacheslav.suhov.imeit.util.Constants

@RunWith(RobolectricTestRunner::class)
class LocalRepositoryTest {

    var instance: LocalRepository? = null
    var institute: String? = null
    var faculty: String? = null
    var group: String? = null
    var groupID: Int? = null
    var isFirstRun: Boolean? = null
    var isSelectedGroup: Boolean? = null
    var isCustomScheduleCall: Boolean? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {

        instance = LocalRepository()

        Hawk.init(RuntimeEnvironment.application.applicationContext)
        // Факультет
        faculty = Hawk.get(Constants.KEY_NAME_FACULTY, Constants.DEF_FACULTY)

        // Институт
        institute = Hawk.get(Constants.KEY_INSTITUTE, Constants.DEF_INSTITUTE)

        // Имя группы
        group = Hawk.get(Constants.KEY_NAME_GROUP, Constants.DEF_NAME_GROUP)

        // ID Группы
        groupID = Hawk.get(Constants.KEY_GROUP_ID, Constants.DEF_GROUP_ID)

        // Первый запуск
        isFirstRun = Hawk.get(Constants.KEY_FIST_RUN, Constants.DEF_FIRST_RUN)

        // Выбрана ли группа
        isSelectedGroup = Hawk.get(Constants.KEY_GROUP_ID, Constants.DEF_GROUP_ID) != 0

        // Изменены ли настройки времени звонков
        isCustomScheduleCall = Hawk.get(Constants.KEY_EDITED_CALL, Constants.DEF_EDITED_CALL)
    }

    @Test
    fun getInstance() {
        assertTrue(instance == LocalRepository())
        assertNotNull(instance)
    }
}