package com.lecture.portfolio.admin.context.achievement.form

import com.lecture.portfolio.domain.entity.Achievement
import jakarta.validation.constraints.NotBlank
import java.time.LocalDate

data class AchievementForm(

    @field:NotBlank(message = "필수값입니다.") // blank인지 확인하고 비어있으면 message에 설정한게 출력됨
    val title: String,

    @field:NotBlank(message = "필수값입니다.")
    val description: String,

    @field:NotBlank(message = "필수값입니다.")
    val host: String,

    @field:NotBlank(message = "필수값입니다.")
    val achievedDate: String,

    val isActive: Boolean

) {
    fun toEntity(): Achievement {
        return Achievement(
            title = this.title,
            description = this.description,
            host = this.host,
            achievedDate = LocalDate.parse(this.achievedDate),
            isActive = this.isActive
        )
    }

    fun toEntity(id: Long): Achievement {
        val achievement = this.toEntity()
        achievement.id = id

        return achievement
    }
}