package com.lecture.portfolio.presentation.service

import com.lecture.portfolio.presentation.dto.IntroductionDTO
import com.lecture.portfolio.presentation.dto.LinkDTO
import com.lecture.portfolio.presentation.dto.ProjectDTO
import com.lecture.portfolio.presentation.dto.ResumeDTO
import com.lecture.portfolio.presentation.repository.PresentationRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class PresentationService (
    private val presentationRepository: PresentationRepository
){
    @Transactional(readOnly = true)
    fun getIntroductions(): List<IntroductionDTO> {
        val introductions = presentationRepository.getActiveIntroductions()
        return introductions.map { introduction -> IntroductionDTO(introduction) }
    }
    @Transactional(readOnly = true)
    fun getLinks(): List<LinkDTO> {
        val links = presentationRepository.getActiveLinks()
        return links.map { link -> LinkDTO(link) }
    }
    @Transactional(readOnly = true)
    fun getResume(): ResumeDTO {
        val experiences = presentationRepository.getActiveExperiences()
        val achievements = presentationRepository.getActiveAchievements()
        val skills = presentationRepository.getActiveSkills()
        return ResumeDTO(
            experiences = experiences,
            achievements = achievements,
            skills = skills
        )
    }
    @Transactional(readOnly = true)
    fun getProjects(): List<ProjectDTO> {
        val projects = presentationRepository.getActiveProjects()
        return projects.map { project -> ProjectDTO(project) }
    }
}