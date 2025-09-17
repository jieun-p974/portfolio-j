package com.lecture.portfolio.admin.context.achievement.service

import com.lecture.portfolio.admin.data.TableDTO
import com.lecture.portfolio.domain.entity.Achievement
import com.lecture.portfolio.domain.repository.AchievementRepository
import org.springframework.stereotype.Service

@Service
class AdminAchievementService (private val achievementRepository: AchievementRepository){
    fun getAchievementTable(): TableDTO{
        val classInfo = Achievement::class
        val entities = achievementRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}