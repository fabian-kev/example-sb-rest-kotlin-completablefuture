package com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.interactor.impl

import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.interactor.CreateStudent
import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.persistence.entity.StudentEntity
import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.persistence.repository.StudentRepository
import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.request.StudentForm
import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.response.StudentResource
import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.CompletableFuture

@Service
class CreateStudentImpl(
        private val studentRepository: StudentRepository
) : CreateStudent {
    override fun execute(studentForm: StudentForm): CompletableFuture<StudentResource> {
        return CompletableFuture.supplyAsync {
                        StudentEntity(
                                name = studentForm.name,
                                age = studentForm.age,
                                createdDate = Date()
                        )
                }.thenApplyAsync { studentRepository.save(it) }
                .thenApply {
                    StudentResource(
                            id = it.id,
                            name = it.name,
                            age = it.age,
                            createdDate = it.createdDate
                    )
                }
    }
}