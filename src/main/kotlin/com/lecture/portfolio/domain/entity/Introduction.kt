package com.lecture.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Introduction : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "introduction_id")
    var id: Long? = null // ?는 null허용이라는 뜻
}