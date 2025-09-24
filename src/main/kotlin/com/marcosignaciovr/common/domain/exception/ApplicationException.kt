package com.marcosignaciovr.common.domain.exception

open class ApplicationException(override val message: String): RuntimeException(message)