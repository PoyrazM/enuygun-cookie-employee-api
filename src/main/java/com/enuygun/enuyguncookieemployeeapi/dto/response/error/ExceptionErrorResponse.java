package com.enuygun.enuyguncookieemployeeapi.dto.response.error;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionErrorResponse {
    String error;
    int statusCode;
}



