package com.lecture.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

//여러 엔티티의 공통 칼럼을 갖고 있는 상위 클래스
@MappedSuperclass
abstract class BaseEntity {
    @CreatedDate
    @Column(nullable = false, updatable = false) // null일 수 없음, 업데이트 불가능
    var createdDateTime: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    @Column(nullable = false)
    var updatedDateTime: LocalDateTime = LocalDateTime.now()
}