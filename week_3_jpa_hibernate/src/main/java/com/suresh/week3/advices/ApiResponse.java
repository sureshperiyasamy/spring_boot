package com.suresh.week3.advices;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

    private LocalDateTime currentTimeStamp;
    private T data;
    private ApiError apiError;

    public ApiResponse() {
        this.currentTimeStamp =  LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError apiError) {
        this();
        this.apiError = apiError;
    }
}
