package com.lecture.portfolio.domain.entity

import com.lecture.portfolio.domain.constant.SkillType
import jakarta.persistence.*

@Entity
class Skill(
    name: String,
    type: String,
    isActive:  Boolean
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    var id: Long? = null // ?는 null허용이라는 뜻

    var name: String = name

    @Column(name = "skill_type")
    @Enumerated(value = EnumType.STRING)
    var type: SkillType = SkillType.valueOf(type) // type(문자열)과 일치하는 값을 SkillType에서 찾아서 return

    var isActive: Boolean = isActive
}