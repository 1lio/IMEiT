package ru.vyaacheslav.suhov.imeit.repository

import com.orhanobut.hawk.Hawk
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_COUNT_PAIR
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_EDITED_CALL
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_FACULTY
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_FIRST_RUN
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_GROUP_ID
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_INSTITUTE
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_NAME_GROUP
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_USER
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_COUNT_PAIR
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_EDITED_CALL
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_FIST_RUN
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_GROUP_ID
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_INSTITUTE
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_NAME_FACULTY
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_NAME_GROUP
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_USER

/** Здесь храним локальные данные */
class LocalRepository {
    private val instance: LocalRepository? = null

    // Имя пользователя
    var userName:String
        set(value) {Hawk.put(KEY_USER,value)}
        get() = Hawk.get(KEY_USER, DEF_USER)

    // Факультет
    var faculty: String
        set(value) { Hawk.put(KEY_NAME_FACULTY, value) }
        get() = Hawk.get(KEY_NAME_FACULTY, DEF_FACULTY)

    // Институт
    var institute: String
        set(value) { Hawk.put(KEY_INSTITUTE, value) }
        get() = Hawk.get(KEY_INSTITUTE, DEF_INSTITUTE)

    // Имя группы
    var group: String
        set(value) { Hawk.put(KEY_NAME_GROUP, value) }
        get() = Hawk.get(KEY_NAME_GROUP, DEF_NAME_GROUP)

    // ID Группы
    var groupID: Int
        set(value) { Hawk.put(KEY_GROUP_ID, value) }
        get() = Hawk.get(KEY_GROUP_ID, DEF_GROUP_ID)

    // Первый запуск
    var isFirstRun: Boolean
        set(value) { Hawk.put(KEY_FIST_RUN, value) }
        get() = Hawk.get(KEY_FIST_RUN, DEF_FIRST_RUN)

    // Выбрана ли группа
    var isSelectedGroup: Boolean
        set(value) { Hawk.put(KEY_GROUP_ID, value) }
        get() = Hawk.get(KEY_GROUP_ID, DEF_GROUP_ID) != 0

    // Изменены ли настройки времени звонков
    var isChangedPref:Boolean
        set(value) {Hawk.put(KEY_EDITED_CALL,value)}
        get() = Hawk.get(KEY_EDITED_CALL, DEF_EDITED_CALL)

    // Колличество пар
    var countPair:Int
        set(value){Hawk.put(KEY_COUNT_PAIR,value)}
        get() = Hawk.get(KEY_COUNT_PAIR,DEF_COUNT_PAIR)

    fun getInstance() = this.instance ?: LocalRepository()
}