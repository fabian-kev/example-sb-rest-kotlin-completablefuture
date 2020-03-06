package com.fbiankevin.crud.examplesbrestcompletablefuturekotlin.persistence.entity

import org.springframework.data.annotation.CreatedDate
import java.util.*
import javax.persistence.*

@Entity(name="Student")
@Table(name="STUDENT")
data class StudentEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        var name: String?,
        var age: Int?,
        @CreatedDate
        val createdDate: Date? = null
)