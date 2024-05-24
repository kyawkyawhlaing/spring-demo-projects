package org.kyawhlaing.apachepoi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor
public class ErrorResponseDto {
    private LocalDateTime timestamp;
    private String apiPath;
    private HttpStatus errorCode;
    private String errorMessage;
}
