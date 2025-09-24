package com.marcosignaciovr.common.application.dto.response

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.time.LocalDateTime

data class CustomResponse<T>(
    val success: Boolean,
    val message: String,
    val data: T? = null,
    val timestamp: LocalDateTime = LocalDateTime.now()
)

typealias ApiResponse<T> = ResponseEntity<CustomResponse<T>>

fun <T> okResponse(data: T? = null, message: String ="Success" ): ApiResponse<T> =
    ResponseEntity.ok(
        CustomResponse(
            success = true,
            message = message,
            data = data
        )
    )

fun <T> errorResponse(message: String, status: HttpStatus = HttpStatus.BAD_REQUEST): ApiResponse<T> =
    ResponseEntity.status(status).body(
        CustomResponse(
            success = false,
            message = message,
            data = null
        )
    )

