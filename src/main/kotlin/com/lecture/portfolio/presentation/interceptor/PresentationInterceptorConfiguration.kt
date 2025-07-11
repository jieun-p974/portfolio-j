package com.lecture.portfolio.presentation.interceptor

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class PresentationInterceptorConfiguration (
    private val presentationInterceptor: PresentationInterceptor
) : WebMvcConfigurer{
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(presentationInterceptor)
            .addPathPatterns("/**") // 모든경로에 대해서 실행
            .excludePathPatterns("/assets/**","/css/**","/js/**","/admin/**","/h2**","/favicon/ico","/error") // 제외할 경로들
    }
}