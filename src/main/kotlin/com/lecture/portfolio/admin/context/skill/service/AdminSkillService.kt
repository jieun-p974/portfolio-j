package com.lecture.portfolio.admin.context.skill.service

import com.lecture.portfolio.admin.data.TableDTO
import com.lecture.portfolio.domain.entity.Skill
import com.lecture.portfolio.domain.repository.SkillRepository
import org.springframework.stereotype.Service

@Service
class AdminSkillService (private val skillRepository: SkillRepository){
    fun getSkillTable(): TableDTO{
        val classInfo = Skill::class
        val entities = skillRepository.findAll()

        return TableDTO.from(classInfo,entities)
    }
}