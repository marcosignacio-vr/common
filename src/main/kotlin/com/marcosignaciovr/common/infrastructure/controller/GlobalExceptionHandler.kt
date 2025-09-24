package com.marcosignaciovr.common.infrastructure.controller

import com.marcosignaciovr.common.application.dto.response.ApiResponse
import com.marcosignaciovr.common.application.dto.response.errorResponse
import com.marcosignaciovr.common.domain.exception.ApplicationException
import com.marcosignaciovr.common.domain.exception.DataBaseException
import com.marcosignaciovr.common.domain.exception.DomainException
import com.marcosignaciovr.common.domain.exception.TestException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException::class)
    fun handleApplicationException(e: ApplicationException): ApiResponse<Map<String, String>> {
        return errorResponse(
            status = HttpStatus.INTERNAL_SERVER_ERROR,
            message = e.message)
    }

    @ExceptionHandler(DomainException::class)
    fun handleDomainException(e: DomainException): ApiResponse<Map<String, String>> {
        return errorResponse(
            status = HttpStatus.INTERNAL_SERVER_ERROR,
            message = e.message)
    }

    @ExceptionHandler(DataBaseException::class)
    fun handleDataBaseException(e: DataBaseException): ApiResponse<Map<String, String>> {
        return errorResponse(
            status = HttpStatus.INTERNAL_SERVER_ERROR,
            message = e.message)
    }

    @ExceptionHandler(TestException::class)
    fun handleTestException(e: TestException): ApiResponse<Map<String, String>> {
        return errorResponse(
            status = HttpStatus.INTERNAL_SERVER_ERROR,
            message = "HEY THERE, I'M A TEST EXCEPTION")
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(e: Exception): ResponseEntity<Map<String, String>> {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(mapOf("error" to "Unexpected error: ${e.message}"))
    }
}