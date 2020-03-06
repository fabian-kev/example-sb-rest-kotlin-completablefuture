package com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.interactor

import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.response.StudentResource
import java.util.concurrent.CompletableFuture

interface DeleteStudent {
    fun execute(id:Long): CompletableFuture<StudentResource>
}