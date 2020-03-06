package com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.interactor.impl

import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.interactor.DeleteStudent
import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.persistence.repository.StudentRepository
import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.response.StudentResource
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class DeleteStudentImpl(
        private val studentRepository: StudentRepository
) : DeleteStudent {
    override fun execute(id: Long): CompletableFuture<StudentResource> =
            CompletableFuture.supplyAsync {
                studentRepository.findById(id).orElseThrow { RuntimeException("Student id $id is not found.") }
                    }.thenApplyAsync { studentRepository.delete(it); it }
                    .thenApply {
                        StudentResource(
                                id = it.id,
                                name = it.name,
                                age = it.age,
                                createdDate = it.createdDate
                        )
                    }


}