package com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.controller

import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.interactor.CreateStudent
import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.interactor.GetStudents
import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.request.StudentForm
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/students")
class StudentController(
        private val createStudent: CreateStudent,
        private val getStudents: GetStudents
) {


    @PostMapping
    fun create(@RequestBody studentForm: StudentForm) = createStudent.execute(studentForm)

    @GetMapping
    fun getStudents() = getStudents.execute()
}