package com.lecture.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ProjectSkill(proejct: Project, skill: Skill) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_skill_id")
    var id: Long? = null // ?는 null허용이라는 뜻

    @ManyToOne(targetEntity = Project::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    var proejct: Project = proejct

    @ManyToOne(targetEntity = Skill::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id", nullable = false)
    var skill: Skill = skill
}