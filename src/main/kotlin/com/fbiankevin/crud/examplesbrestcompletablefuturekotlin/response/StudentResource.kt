package com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.response

import java.util.*

data class StudentResource(
        val id: Long? = null,
        var name: String?,
        var age: Int?,
        val createdDate: Date? = null
)