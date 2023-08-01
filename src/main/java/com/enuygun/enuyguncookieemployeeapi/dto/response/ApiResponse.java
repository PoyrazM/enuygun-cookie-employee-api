package com.enuygun.enuyguncookieemployeeapi.dto.response;

import lombok.Data;
import java.io.*;
import java.time.LocalDateTime;

@Data
public class ApiResponse<T> implements Serializable {
    private boolean isSuccess;
    private String status;
    private String message;
    private LocalDateTime responseTime;
    private T data;

    public ApiResponse(boolean isSuccess, String status, String message, T data) {
        this.isSuccess = isSuccess;
        this.status = status;
        this.message = message;
        this.responseTime = LocalDateTime.now();
        this.data = data;
    }

    @Serial
    private static final long serialVersionUID = 0L;

    @Override
    public boolean equals(Object obj) {
        return obj == this || obj != null && obj.getClass() == this.getClass();
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "ApiResponse[]";
    }

    public static <T> ApiResponse<T> of(String message, T t) {
        return new ApiResponse<>(true, "success", message, t);
    }

    public static <T> ApiResponse<T> error(String message, T t) {return new ApiResponse<>(false, "failed", message, t);}
}



