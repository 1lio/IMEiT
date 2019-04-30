package ru.vyaacheslav.suhov.imeit.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.orhanobut.hawk.Hawk
import ru.vyaacheslav.suhov.imeit.util.AppConfig.KEY_GROUP
import ru.vyaacheslav.suhov.imeit.util.AppConfig.KEY_INSTITUTE
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_GROUP
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_INSTITUTE

class UpToolbarViewModel : ViewModel() {

    private val nameInstitute = MutableLiveData<String>()
    private val nameGroup = MutableLiveData<String>()

    init {
        nameInstitute.value = Hawk.get(KEY_INSTITUTE, DEF_INSTITUTE)
        nameGroup.value = Hawk.get(KEY_GROUP, DEF_GROUP)
    }

    fun observeNameInstitute(owner: LifecycleOwner, observer: Observer<String>) {
        nameInstitute.observe(owner, observer)
    }

    fun observeNameGroup(owner: LifecycleOwner, observer: Observer<String>) {
        nameGroup.observe(owner, observer)
    }

    fun setNameInstitute(institute: String) {
        Hawk.put(KEY_INSTITUTE, institute)
        nameInstitute.postValue(institute)
    }

    fun setNameGroup(group: String) {
        Hawk.put(KEY_GROUP, group)
        nameGroup.postValue(group)
    }
}