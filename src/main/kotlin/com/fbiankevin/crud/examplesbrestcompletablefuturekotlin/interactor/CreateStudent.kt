package com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.interactor

import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.request.StudentForm
import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.response.StudentResource
import java.util.concurrent.CompletableFuture

interface CreateStudent {
    fun execute(studentForm: StudentForm): CompletableFuture<StudentResource>
}