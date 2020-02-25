package ru.vyaacheslav.suhov.imeit.viewmodel

import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.util.AppConstants.DIALOG_EXIT
import ru.vyaacheslav.suhov.imeit.util.AppConstants.DIALOG_GROUP
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_ACCOUNT
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_CALLS
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_CALLS_PREF
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_EMPTY_SCHEDULE
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_MAPS
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_SCHEDULE
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_SIGN_IN
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_SIGN_UP_FIRST
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_SIGN_UP_SECOND
import ru.vyaacheslav.suhov.imeit.util.AppConstants.LOG_DEBUG
import ru.vyaacheslav.suhov.imeit.util.ErrorEvent
import ru.vyaacheslav.suhov.imeit.util.pushFragment
import ru.vyaacheslav.suhov.imeit.util.toast
import ru.vyaacheslav.suhov.imeit.view.ftagments.AccountFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.auth.SignInFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.auth.SignUpFirstFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.auth.SignUpSecondFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.calls.CallFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.calls.CallSetupFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.maps.MapsPagerFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.schedule.FragmentEmptyGroup
import ru.vyaacheslav.suhov.imeit.view.ftagments.schedule.SchedulePagerFragment

class ActivityController(private val activity: AppCompatActivity) {

    private val controlModel = ViewModelProvider(activity)[ControlViewModel::class.java]
    private val mainModel = ViewModelProvider(activity)[ActivityViewModel::class.java]
    private val authModel = ViewModelProvider(activity)[AuthViewModel::class.java]

    init {
        observeAuth()
        observeVisibleUI()

        onControl()
        onControlDialogs()

        observeErrorMsg()
    }

    private fun onControl() {

        controlModel.observeFragmentID(activity, Observer {

            val fragment: Fragment? = when (it) {

                FRAGMENT_SIGN_IN -> SignInFragment()
                FRAGMENT_SIGN_UP_FIRST -> SignUpFirstFragment()
                FRAGMENT_SIGN_UP_SECOND -> SignUpSecondFragment()

                FRAGMENT_EMPTY_SCHEDULE -> FragmentEmptyGroup()
                FRAGMENT_SCHEDULE -> SchedulePagerFragment()

                FRAGMENT_CALLS -> CallFragment()
                FRAGMENT_CALLS_PREF -> CallSetupFragment()

                FRAGMENT_ACCOUNT -> AccountFragment()

                FRAGMENT_MAPS -> MapsPagerFragment()
                else -> null
            }


            fragment?.pushFragment(activity.supportFragmentManager)
                ?: Log.e(LOG_DEBUG, "Not fragment")
        })

    }

    private fun onControlDialogs() {

        controlModel.observeDialogID(activity, Observer {

            val dialog: AlertDialog? = when (it) {
                DIALOG_GROUP -> dialogSelectGroup()
                DIALOG_EXIT -> dialogExit()
                else -> null
            }

            dialog?.show() ?: Log.e(LOG_DEBUG, "Not dialog")
        })
    }


    private fun dialogSelectGroup(): AlertDialog {
        return AlertDialog.Builder(activity)
            .setTitle(R.string.group)
            .setNeutralButton(activity.resources.getString(R.string.cancel)) { d, _ -> d.cancel() }
            .setSingleChoiceItems(mainModel.getListGroups(), mainModel.getSelectedId())
            { d, i ->
                mainModel.setSelectedId(i)
                loadStartFragment()
                d.cancel()
            }
            .create()
    }

    private fun dialogExit(): AlertDialog {
        return AlertDialog.Builder(activity)
            .setTitle(activity.resources.getString(R.string.exit_of_app))
            .setNeutralButton(activity.resources.getString(R.string.cancel)) { d, _ -> d.cancel() }
            .setPositiveButton(activity.resources.getString(R.string.yes)) { d, _ -> d.dismiss(); activity.finish() }
            .create()
    }

    private fun loadStartFragment() {
        if (mainModel.isSelectedGroup()) controlModel.setFragmentId(FRAGMENT_SCHEDULE)
        else controlModel.setFragmentId(FRAGMENT_EMPTY_SCHEDULE)
    }

    private fun observeAuth() {
        authModel.observeAuth(activity, Observer {
            if (it) {
                controlModel.setVisibleUI(visibility = true)
                controlModel.setFragmentId(controlModel.getFragmentSchedule())
            } else {
                //   navigation.dismiss()
                controlModel.setFragmentId(FRAGMENT_SIGN_IN)
                controlModel.setVisibleUI(visibility = false)
            }
        })
    }

    private fun observeVisibleUI() {


        val bottomView: BottomNavigationView = activity.findViewById(R.id.bottomBar)

        controlModel.observeVisibleUI(activity, Observer { visible ->
            bottomView.visibility = if (visible) View.VISIBLE else View.GONE
        })
    }

    private fun observeErrorMsg() {
        authModel.observeAuthErrorsMsg(activity, Observer {
            val msg: Int = when (it) {
                ErrorEvent.ERROR_CONNECTIONS -> R.string.error_connections
                ErrorEvent.ERROR_PASS -> R.string.error_pass
                ErrorEvent.ERROR_EMAIL -> R.string.error_email
                ErrorEvent.ERROR_LOGIN -> R.string.error_login
                ErrorEvent.ERROR_SERVER -> R.string.error_server
                ErrorEvent.ERROR_CREATE_ACCOUNT -> R.string.error_create_account
                else -> 0
            }
            toast(context = activity, msg = msg)
        })
    }
}