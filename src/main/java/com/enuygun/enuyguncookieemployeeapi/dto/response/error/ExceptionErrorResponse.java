package com.enuygun.enuyguncookieemployeeapi.dto.response.error;

import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionErrorResponse {
    String status;
    LocalDateTime timeStamp;
    String message;
    int statusCode;
}



