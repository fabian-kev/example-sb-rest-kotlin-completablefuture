package com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.request

data class StudentForm(
        val id: Long? = null,
        var name: String?,
        var age: Int?
)