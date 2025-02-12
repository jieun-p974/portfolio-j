package com.lecture.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ExperienceDetail(content: String, isActive: Boolean) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_detail_id")
    var id: Long? = null // ?는 null허용이라는 뜻

    var content: String = content

    var isActive: Boolean = isActive

    fun update(content: String, isActive: Boolean){
        this.content = content
        this.isActive = isActive
    }
}