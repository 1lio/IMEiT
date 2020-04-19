package ru.suhov.student

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.student.assistant.auth.ui.AuthFragment
import ru.suhov.student.features.AppConstants.DIALOG_EXIT
import ru.suhov.student.features.viewmodel.ControlViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var model: ControlViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity)

        if (savedInstanceState == null) {

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, AuthFragment())
                .commitNow()

            /*ActivityController(activity = this@MainActivity)
            model = ViewModelProvider(this@MainActivity)[ControlViewModel::class.java]

            appBar.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.account -> model.setFragmentId(FRAGMENT_ACCOUNT)
                    R.id.bells -> model.setFragmentId(FRAGMENT_CALLS)
                    R.id.schedule -> model.setFragmentId(FRAGMENT_SCHEDULE)
                    R.id.maps -> model.setFragmentId(FRAGMENT_MAPS)
                    R.id.chat -> model.setFragmentId(FRAGMENT_SCHEDULE)
                }
                true
            }*/

        }
    }

    override fun onBackPressed() {
        model.setDialogID(DIALOG_EXIT)
    }
}