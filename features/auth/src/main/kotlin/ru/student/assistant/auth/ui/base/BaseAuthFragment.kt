package ru.student.assistant.auth.ui.base

import androidx.fragment.app.Fragment
import ru.student.assistant.auth.viewmodel.AuthState

// По структуре фрагменты авторизации одинаковы, принято решении вынести в базовый фрагмент
abstract class BaseAuthFragment : Fragment() {

    // У каждого фрагмента есть state для того чтобы viewModel знала какой фрагмент на сцене
    abstract val state: AuthState

    // Везде есть поле с валидатором
    var isValid: Boolean = false

}