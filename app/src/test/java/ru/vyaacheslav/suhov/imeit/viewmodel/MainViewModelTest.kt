package ru.vyaacheslav.suhov.imeit.viewmodel

import androidx.lifecycle.MutableLiveData
import com.orhanobut.hawk.Hawk
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import ru.vyaacheslav.suhov.imeit.repository.LocalRepository
import ru.vyaacheslav.suhov.imeit.repository.MainInteractor

@RunWith(RobolectricTestRunner::class)
class MainViewModelTest {


    lateinit var viewModel: MainViewModel

    @Mock lateinit var interactor: MainInteractor
    @Mock lateinit var localRepository: LocalRepository

    // Проверки
    private val isFirstRun = MutableLiveData<Boolean>()
    private val isSelectedGroup = MutableLiveData<Boolean>()
    //Toolbar
    private val titleToolbar = MutableLiveData<String>()
    private val subtitleToolbar = MutableLiveData<String>()
    // Настройки
    private val selectedListId = MutableLiveData<Int>()
    // Сохраненные  данные | Институт и факультет почти не используются. В дальнейшем будут.
    private val currentFaculty = localRepository.faculty
    private val currentInstitute = localRepository.institute
    private val currentGroup = localRepository.group
    // Лист со всеми группами
    private val listGroupsData = MutableLiveData<Array<String>>()
    var listGroup: ArrayList<String> = arrayListOf()

    @Before
    fun setUp() {
        Hawk.init(RuntimeEnvironment.application.applicationContext) //androidx

        viewModel = MainViewModel()
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun init() {}

}