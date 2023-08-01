package com.enuygun.enuyguncookieemployeeapi.mapper;

import com.enuygun.enuyguncookieemployeeapi.dto.response.error.ExceptionErrorResponse;
import java.time.LocalDateTime;

public class ErrorResponseParser {
    private ErrorResponseParser() {}

    public static ExceptionErrorResponse exceptionParser(String message, LocalDateTime timeStamp, int statusCode) {
        return ExceptionErrorResponse.builder()
                .status("failed")
                .message(message)
                .timeStamp(timeStamp)
                .statusCode(statusCode)
                .build();
    }
}
