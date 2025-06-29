package com.lecture.portfolio.presentation.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PresentationViewController {

    @GetMapping("/test")
    fun test(): String{
        return "test" // test.html을 실행한다는 뜻
    }
}