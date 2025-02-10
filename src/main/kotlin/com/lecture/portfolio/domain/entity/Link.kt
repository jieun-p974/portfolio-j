package com.lecture.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Link : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "link_id")
    var id: Long? = null // ?는 null허용이라는 뜻
}