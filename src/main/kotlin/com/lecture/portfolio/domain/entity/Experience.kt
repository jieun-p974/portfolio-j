package com.lecture.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Experience : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    var id: Long? = null // ?는 null허용이라는 뜻
}