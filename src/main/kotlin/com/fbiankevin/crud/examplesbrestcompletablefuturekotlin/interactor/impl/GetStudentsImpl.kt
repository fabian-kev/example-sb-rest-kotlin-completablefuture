package com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.interactor.impl

import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.interactor.GetStudents
import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.persistence.repository.StudentRepository
import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.response.StudentResource
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class GetStudentsImpl(
        private val studentRepository: StudentRepository
) : GetStudents {
    override fun execute(): CompletableFuture<List<StudentResource>> {
        return CompletableFuture.supplyAsync { studentRepository.findAll() }
                .thenApply { mutableList ->
                    mutableList.map {
                        StudentResource(
                                id = it.id,
                                age = it.age,
                                name = it.name,
                                createdDate = it.createdDate
                        )
                    }
                }
    }
}