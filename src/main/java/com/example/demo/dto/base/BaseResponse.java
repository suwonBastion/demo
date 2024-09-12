package com.example.demo.dto.base;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse <T> {
    private HttpStatus code;
    private String msg;
    private T data;
}
