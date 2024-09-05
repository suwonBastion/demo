package com.example.demo.controller.godomall;

import com.example.demo.service.godomall.GodomallService;
import com.example.demo.webclient.godomall.dto.OrderSearchParam;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/godomall")
public class GodomallController {
    private final GodomallService godomallService;

    @PostMapping("/order-search")
    public ResponseEntity<?> orderSearch(@Valid @RequestBody OrderSearchParam param) {
        return godomallService.orderSearch(param);
    }
}
