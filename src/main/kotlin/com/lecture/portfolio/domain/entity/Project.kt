package com.lecture.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Project(
    name: String,
    description: String,
    startYear: Int,
    startMonth: Int,
    endYear: Int?,
    endMonth: Int?,
    isActive: Boolean
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    var id: Long? = null // ?는 null허용이라는 뜻

    var name: String = name

    var description: String = description

    var startYear: Int = startYear

    var startMonth: Int = startMonth

    var endYear: Int? = endYear

    var endMonth: Int? = endMonth

    var isActive: Boolean = isActive

    @OneToMany(targetEntity = ProjectDetail::class,
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL])
    @JoinColumn(name = "project_id")
    var details: MutableList<ProjectDetail> = mutableListOf()

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    var skills: MutableList<ProjectSkill> = mutableListOf()

    fun getEndYearMoth(): String{
        if(endYear == null || endMonth == null){
            return "Present"
        }
        return "${endYear}.${endMonth}" //2025.02 같은 방식으로 return
    }

    fun update(name: String, description: String, startYear: Int, startMonth: Int,
               endYear: Int?, endMonth: Int?, isActive: Boolean){
        this.name = name
        this.description = description
        this.startYear = startYear
        this.startMonth = startMonth
        this.endYear = endYear
        this.endMonth = endMonth
        this.isActive = isActive
    }

    fun addDetails(details: MutableList<ProjectDetail>?){
        if(details != null){
            this.details.addAll(details)
        }
    }
}