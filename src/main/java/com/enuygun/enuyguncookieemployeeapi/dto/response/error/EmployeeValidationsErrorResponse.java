package com.enuygun.enuyguncookieemployeeapi.dto.response.error;

import lombok.*;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeValidationsErrorResponse {
    private Map<String, String> validationErrors;
    private int statusCode;
}
