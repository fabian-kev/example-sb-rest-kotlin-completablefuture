package com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.model

import java.util.*

data class Student(
        val id: Long? = null,
        var name: String?,
        var age: Int?,
        val createdDate: Date? = null
)