package com.example.petfinder.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;
    private int status;
    private String error;

    public CustomErrorResponse(Exception exception, HttpStatus status){
        this.timestamp = LocalDateTime.now();
        this.error = exception.getMessage();
        this.status = status.value();
    }
}
