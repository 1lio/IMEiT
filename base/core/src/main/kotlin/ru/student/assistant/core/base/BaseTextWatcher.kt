package ru.student.assistant.core.base

import android.text.Editable
import android.text.TextWatcher

abstract class BaseTextWatcher : TextWatcher {

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun afterTextChanged(s: Editable?) {}

    // Override method
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
}