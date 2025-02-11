package com.lecture.portfolio.domain.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Achievement(
    title: String,
    description: String,
    achievedDate: LocalDate?,
    host: String,
    isActive: Boolean
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id")
    var id: Long? = null // ?는 null허용이라는 뜻

    var title: String = title

    var description: String = description

    var achievedDate: LocalDate? = achievedDate

    var host: String = host

    var isActive: Boolean = isActive
}