package com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.persistence.repository

import com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.persistence.entity.StudentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : JpaRepository<StudentEntity, Long>