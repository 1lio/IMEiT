package ru.student.core.impl

import ru.student.core.base.Repository

class LocalRepository : Repository() {

    override var isAuth: Boolean
        get() = true
        set(value) {}
}