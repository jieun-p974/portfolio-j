package com.lecture.portfolio.presentation.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PresentationApiController {

    @GetMapping("test")
    fun test(): String{
        return "OK" // view파일을 찾는게 아니라 return한 객체를 body에 넣어주는 것
    }
}