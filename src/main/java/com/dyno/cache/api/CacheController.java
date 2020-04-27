package com.dyno.cache.api;

import com.dyno.cache.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by artem on 3/18/20.
 */
@RestController
@RequiredArgsConstructor
public class CacheController {

    private final RequestService service;

    @GetMapping("iterate/{key}")
    public ResponseEntity getIteratedCached(@PathVariable String key) {
        return ResponseEntity.ok(service.getIteration(key));
    }

}
