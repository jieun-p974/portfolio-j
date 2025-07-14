package com.lecture.portfolio.admin.exception

import org.springframework.http.HttpStatus

abstract class AdminException (
    httpStatus: HttpStatus,
    message: String
) : RuntimeException(message){
    val httpStatus: HttpStatus = httpStatus
}

class AdminBadRequestException(message: String) : AdminException(HttpStatus.BAD_REQUEST, message)

class AdminInternalServerErrorExeption(message: String) : AdminException(HttpStatus.INTERNAL_SERVER_ERROR, message)