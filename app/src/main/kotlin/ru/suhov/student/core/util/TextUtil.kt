package ru.suhov.student.core.util

import android.widget.EditText
import ru.suhov.student.R


fun EditText.isValidEmail(): Boolean {
    return when {
        this.text.toString().isEmpty() -> {
            this.error = resources.getString(R.string.is_not_empty)
            false
        }

        !android.util.Patterns.EMAIL_ADDRESS.matcher(this.text.toString()).matches() -> {
            this.error = resources.getString(R.string.incorrect_email)
            false
        }

        else -> {
            this.error = null
            true
        }
    }

}

fun EditText.isValidPass(childEdit: EditText): Boolean {
    return when {
        this.text.toString().isEmpty() -> {
            this.error = resources.getString(R.string.is_not_empty)
            false
        }

        this.text.toString().length < 6 -> {
            this.error = resources.getString(R.string.error_min_length_pass)
            false
        }

        this.text.toString() != childEdit.text.toString() -> {
            childEdit.error = resources.getString(R.string.pass_do_not_match)
            false
        }

        else -> {
            this.error = null
            childEdit.error = null
            true
        }
    }
}

fun EditText.isValidPass(): Boolean {
    return when {
        this.text.toString().isEmpty() -> {
            this.error = resources.getString(R.string.is_not_empty)
            false
        }

        this.text.toString().length < 6 -> {
            this.error = resources.getString(R.string.error_min_length_pass)
            false
        }

        else -> {
            this.error = null
            true
        }
    }
}