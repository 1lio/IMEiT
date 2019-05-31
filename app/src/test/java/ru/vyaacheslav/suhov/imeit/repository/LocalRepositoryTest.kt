package ru.vyaacheslav.suhov.imeit.repository

import android.content.Context
import com.orhanobut.hawk.Hawk
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner
import ru.vyaacheslav.suhov.imeit.util.Constants
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_FACULTY
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_INSTITUTE


@RunWith(MockitoJUnitRunner::class)
class LocalRepositoryTest {

    // В локальном репозитории пока хранятся данные примитивных типов
    // Используется библиотека Hawk для работы с SharedPreferences
    // Тут особо тестировать нечего

    // Все данные из LocalRepository
    private var instance: LocalRepository? = null

    private var faculty: String? = null
    private var institute: String? = null
    private var group: String? = null
    private var groupID: Int? = null
    private var isFirstRun: Boolean? = null
    private var isSelectedGroup: Boolean? = null
    private var isCustomScheduleCall: Boolean? = null
    private var context: Context? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        context  = mock(Context::class.java)
        //Инициализируем Hawk
        Hawk.init(context!!.applicationContext).build()
        // Устанавливаем значения до
        instance = LocalRepository()
        faculty = Hawk.get(Constants.KEY_NAME_FACULTY, DEF_FACULTY)
        institute = Hawk.get(Constants.KEY_INSTITUTE, DEF_INSTITUTE)
        group = Hawk.get(Constants.KEY_NAME_GROUP, Constants.NOT_SELECT)
        groupID = Hawk.get(Constants.KEY_GROUP_ID, Constants.DEF_GROUP_ID)
        isFirstRun = Hawk.get(Constants.KEY_FIST_RUN, Constants.DEF_FIRST_RUN)
        isSelectedGroup = Hawk.get(Constants.KEY_GROUP_ID, Constants.DEF_GROUP_ID) != 0
        isCustomScheduleCall = Hawk.get(Constants.KEY_EDITED_CALL, Constants.DEF_EDITED_CALL)
    }

    @Test
    fun testInstance() {
        // Мы не должны получить null, в случае null создаем новый

        // given:
        val instanceTest: Any?
        // instanceTest = FirebaseRealtimeRepository() // Хотя это тупо, но у меня уже такое было))
        // instanceTest = null

        // when:
        instanceTest = instance
        fun getInstance() = instanceTest ?: LocalRepository()

        // then:
        Assert.assertFalse("Instance null", instanceTest == null)
        Assert.assertFalse("Чужой instance", instanceTest != null && instanceTest != LocalRepository())

        Assert.assertTrue("Получили null и заново создали", getInstance() == LocalRepository())
        Assert.assertTrue(instance == LocalRepository())
    }

    @Test
    fun valueTest() {
        // Типы примитивные особо тестировать не чего
        // По идее можно создать функцию и пройти по всём в цикле

        // Проверяем что hawk проинициализиован
        // Институт и факультет пока не изменяемые, проверяем со значение из констатны

        // Институт
        Assert.assertFalse("institute: null", institute == null)
        Assert.assertFalse("institute: неверныей тип", institute is String)
        Assert.assertFalse("institute: пустой символ", institute == "")
        Assert.assertFalse("institute: ожидался $DEF_INSTITUTE", institute == Mockito.anyString())
        Assert.assertTrue(institute == DEF_INSTITUTE)

        // Факультет
        Assert.assertFalse("faculty: null", faculty == null)
        Assert.assertFalse("faculty: неверныей тип", faculty is String)
        Assert.assertFalse("faculty: пустой символ", faculty == "")
        Assert.assertFalse("faculty: ожидался $DEF_FACULTY", faculty == Mockito.anyString())
        Assert.assertTrue(faculty == DEF_FACULTY)

        val testGroup = "ИСиТ-31"
        // Группа
        Assert.assertFalse("group: null", group == null)
        Assert.assertFalse("group: неверныей тип", group is String)
        Assert.assertFalse("group: пустой символ", group == "")
        Assert.assertFalse("group: ожидался $testGroup", group == Mockito.anyString())
        Assert.assertTrue(group is String)

        // ID группы
        Assert.assertFalse("groupID: null", groupID == null)
        Assert.assertFalse("groupID: неверныей тип", groupID is Int)
        Assert.assertFalse("groupID: запрошенный id > чем всего записей в БД $testGroup",
                (groupID!! > 100)) // Для примера в базе только 100 групп
        Assert.assertTrue(group is String)

        // Проверка на первый запуск по идее нужет только тип
        Assert.assertFalse("isFirstRun: null", isFirstRun == null)
        Assert.assertFalse("isFirstRun: неверныей тип", isFirstRun is Boolean)
        Assert.assertTrue(isFirstRun is Boolean)

        // Выбрана ли группа
        Assert.assertFalse("isExistsGroup: null", isSelectedGroup == null)
        Assert.assertFalse("isExistsGroup: неверныей тип", isSelectedGroup is Boolean)
        Assert.assertTrue(isFirstRun is Boolean)

        // Кастоные насторойки времени звонков
        Assert.assertFalse("isExistsGroup: null", isCustomScheduleCall == null)
        Assert.assertFalse("isExistsGroup: неверныей тип", isCustomScheduleCall is Boolean)
        Assert.assertTrue(isFirstRun is Boolean)
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        // зануляем значения
        context = null
        instance = null
        faculty = null
        institute = null
        group = null
        groupID = null
        isFirstRun = null
        isSelectedGroup = null
        isCustomScheduleCall = null
    }
}