package com.example.demo.main.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(value = HttpStatus.NOT_FOUND)
class InvalidUpdateResourceException(resourceName: String?, fieldName: String?, fieldValue: Any) :
    RuntimeException("$resourceName update failed because \'$fieldName\': $fieldValue not match the existed in db!")