package com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.interactor.impl

import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.interactor.UpdateStudent
import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.persistence.repository.StudentRepository
import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.request.StudentForm
import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.response.StudentResource
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.concurrent.CompletableFuture

@Service
class UpdateStudentImpl(
        private val studentRepository: StudentRepository
) : UpdateStudent {
    override fun execute(studentForm: StudentForm): CompletableFuture<StudentResource> {
        if( studentForm.id == null ){
            throw RuntimeException("Student id :${studentForm.id} is required.")
        }
        return CompletableFuture.supplyAsync {
                    studentRepository.findById(studentForm.id).orElseThrow { RuntimeException("Student id: ${studentForm.id} is unable to find.") }
                }.thenApplyAsync {
                    it.age = studentForm.age
                    it.name = studentForm.name

                    studentRepository.save(it)
                }.thenApply {
                    StudentResource(
                            id = it.id,
                            name = it.name,
                            age = it.age,
                            createdDate = it.createdDate
                    )
                }
    }
}