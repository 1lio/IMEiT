package ru.vyaacheslav.suhov.imeit.view.view.auth

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.v_sign_last.view.*
import ru.vyaacheslav.suhov.imeit.MainActivity
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.viewmodel.view.SignUpLastStepModel

class SignUpLastView(context: Context, attr: AttributeSet) : ConstraintLayout(context, attr) {

    private val activity = context as MainActivity
    private val model = ViewModelProviders.of(activity)[SignUpLastStepModel::class.java]

    init {

        LayoutInflater.from(context).inflate(R.layout.v_sign_last, this)
        ed_user_name.error = resources.getString(R.string.is_empty)

        model.observeSignUpButton(activity, Observer { registration.isEnabled = it })

        spinInst()

        ed_user_name.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (validName()) model.setUserName(s.toString())
            }
        })

    }

    private fun validName(): Boolean {

        return when {
            ed_user_name.text.toString().isEmpty() -> {
                ed_user_name.error = resources.getString(R.string.is_empty)
                model.setSignUpButton(false)
                false
            }

            else -> {
                model.setSignUpButton(true)
                ed_user_name.error = null
                true
            }
        }
    }

    private fun spinInst() {

        val adapter = ArrayAdapter<String>(activity, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner_institute.adapter = adapter
        model.observeInstitutes(activity, Observer {
            adapter.addAll(it.toMutableList())
            adapter.notifyDataSetChanged()
        })

        spinner_institute.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                model.setInstitute(position)
                spinFaculty()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

    }

    private fun spinFaculty() {
        model.getFacultyList()

        val adapter = ArrayAdapter<String>(activity, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner_faculty.adapter = adapter
        model.observeFaculty(activity, Observer {
            adapter.clear()
            adapter.addAll(it.toMutableList())
            adapter.notifyDataSetChanged()
        })


        spinner_faculty.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                model.setFaculty(position)
                spinGroup()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun spinGroup() {

        model.getGroupList()

        val adapter = ArrayAdapter<String>(activity, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner_group.adapter = adapter
        model.observeGroup(activity, Observer {
            adapter.clear()
            adapter.addAll(it.toMutableList())
            adapter.notifyDataSetChanged()
        })

        spinner_group.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                model.setGroup(position)
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
}