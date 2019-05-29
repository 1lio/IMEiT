package ru.vyaacheslav.suhov.imeit.view.ftagments.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ru.vyaacheslav.suhov.imeit.LoginActivity
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.viewmodel.view.SignUpLastStepModel
import android.widget.AdapterView

class SingUpLastStepFragment : Fragment() {

    private lateinit var model: SignUpLastStepModel

    private lateinit var spinInstitute: Spinner
    private lateinit var spinFaculty: Spinner
    private lateinit var spinGroup: Spinner

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fr_sign_up2, container, false)
        val activity = context as LoginActivity

        model = ViewModelProviders.of(activity)[SignUpLastStepModel::class.java]

        spinInstitute = v.findViewById(R.id.spinner_institute)
        spinFaculty = v.findViewById(R.id.spinner_faculty)
        spinGroup = v.findViewById(R.id.spinner_group)

        val spinners = arrayOf(spinInstitute, spinFaculty, spinGroup)

        spinners.forEach { s ->
            when (s) {
                spinInstitute -> {
                    model.observeInstitutes(activity, Observer {
                        spinInstitute.adapter = ArrayAdapter<String>(activity, android.R.layout.simple_spinner_item, it)
                    })
                }

                spinFaculty -> {
                    model.observeFaculty(activity, Observer {
                        spinFaculty.adapter = ArrayAdapter<String>(activity, android.R.layout.simple_spinner_item, it)
                    })
                }
                spinGroup -> {
                    model.observeGroup(activity, Observer {
                        spinGroup.adapter = ArrayAdapter<String>(activity, android.R.layout.simple_spinner_item, it)
                    })
                }
            }
            itemSelectedListener(s)
        }

        return v
    }

    // Обрабатываем нажатия

    private fun itemSelectedListener(spinner: Spinner) {

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                when (spinner) {
                    spinInstitute -> {
                        model.setInstitute(position)
                        model.getFaculty()
                    }

                    spinFaculty -> {
                        model.setFaculty(position)
                        model.getGroup()
                    }
                    spinGroup -> model.setGroup(position)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
}