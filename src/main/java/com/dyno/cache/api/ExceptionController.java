package com.dyno.cache.api;

/**
 * Created by artem on 3/18/20.
 */

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value
            = { IllegalArgumentException.class, IllegalStateException.class })
    public ResponseEntity exception() {
        return ResponseEntity.badRequest().body("Exception");
    }

}
