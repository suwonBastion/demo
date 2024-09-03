package com.example.demo.controller;

import com.example.demo.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping()
    public ResponseEntity<?> test2() {
        return testService.test2();
    }

    @GetMapping("/product")
    public ResponseEntity<?> test3(
            @RequestParam(name = "name") String name
    ) {
        return testService.test3(name);
    }

    @PostMapping("/product-order")
    public ResponseEntity<?> test4(@RequestBody Map<String, String> map) throws UnsupportedEncodingException {
        return testService.test4(map);
    }
}
