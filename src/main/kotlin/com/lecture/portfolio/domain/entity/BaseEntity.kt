package com.lecture.portfolio.domain.entity

import jakarta.persistence.MappedSuperclass

//여러 엔티티의 공통 칼럼을 갖고 있는 상위 클래스
@MappedSuperclass
abstract class BaseEntity