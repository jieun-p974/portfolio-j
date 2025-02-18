package com.lecture.portfolio.domain.repository

import com.lecture.portfolio.domain.entity.Experience
import com.lecture.portfolio.domain.entity.ExperienceDetail
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExperienceRepositoryTest (@Autowired val experienceRepository: ExperienceRepository
){
    val DATA_SIZE = 10

    private fun createExperience(n: Int): Experience{
        val experience = Experience(
            title = "${n}",
            description = "테스트 설명 ${n}",
            startYear = 2023,
            startMonth = 9,
            endYear = 2023,
            endMonth = 9,
            isActive = true
        )
        val details = mutableListOf<ExperienceDetail>()
        for (i in 1..n){ // 1..n : 1부터 n까지
            val experienceDetail = ExperienceDetail(content = "테스트${i}", isActive = true)
            details.add(experienceDetail)
        }
        experience.addDetails(details)

        return experience
    }

    @BeforeAll
    fun beforeAll(){
        println("-----데이터 초기화 이전 조회 시작-----")

        val beforeInitialize = experienceRepository.findAll()
        Assertions.assertThat(beforeInitialize).hasSize(0) // 사이즈가 0이면 테스트 통화

        println("-----데이터 초기화 이전 조회 종료-----")

        println("-----테스트 데이터 초기화 이전 조회 시작-----")

        val experiences = mutableListOf<Experience>()
        for(i in 1..DATA_SIZE){
            val experience = createExperience(i)
            experiences.add(experience)
        }
        experienceRepository.saveAll(experiences)

        println("-----테스트 데이터 초기화 이전 조회 종료-----")
    }

    @Test
    fun testFindAll(){
        println("-----findAll 테스트 시작-----")

        val experiences = experienceRepository.findAll()
        Assertions.assertThat(experiences).hasSize(DATA_SIZE)

        println("experiences.size : ${experiences.size}")

        for (experience in experiences) {
            Assertions.assertThat(experience.details).hasSize(experience.title.toInt())
            println("experiences.details.size : ${experience.details.size}")
        }

        println("-----findAll 테스트 시작-----")
    }

    @Test
    fun testFindAllByIsActive(){
        println("-----findAllByIsActive 테스트 시작-----")

        val experiences = experienceRepository.findAllByIsActive(true)
        Assertions.assertThat(experiences).hasSize(DATA_SIZE)

        println("experiences.size : ${experiences.size}")

        for (experience in experiences) {
            Assertions.assertThat(experience.details).hasSize(experience.title.toInt())
            println("experiences.details.size : ${experience.details.size}")
        }

        println("-----findAllByIsActive 테스트 시작-----")
    }
}
