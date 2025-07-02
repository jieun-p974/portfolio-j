package com.lecture.portfolio.presentation.controller

import com.lecture.portfolio.presentation.dto.IntroductionDTO
import com.lecture.portfolio.presentation.dto.LinkDTO
import com.lecture.portfolio.presentation.dto.ProjectDTO
import com.lecture.portfolio.presentation.dto.ResumeDTO
import com.lecture.portfolio.presentation.service.PresentationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PresentationApiController (
    private val presentationService: PresentationService
){
    @GetMapping("test")
    fun test(): String{
        return "OK" // view파일을 찾는게 아니라 return한 객체를 body에 넣어주는 것
    }

    @GetMapping("/v1/introductions")
    fun getIntroductions(): List<IntroductionDTO>{
        return presentationService.getIntroductions()
    }

    @GetMapping("/v1/links")
    fun getLinks(): List<LinkDTO>{
        return presentationService.getLinks()
    }

    @GetMapping("/v1/resume")
    fun getResume(): ResumeDTO{
        return presentationService.getResume()
    }

    @GetMapping("/v1/projects")
    fun getProjects(): List<ProjectDTO>{
        return presentationService.getProjects()
    }
}