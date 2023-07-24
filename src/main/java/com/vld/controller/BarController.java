package com.vld.controller;

import com.vld.controller.dto.BarRequestDto;
import com.vld.controller.dto.BarResponseDto;
import com.vld.service.BarService;
import com.vld.util.BarUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class BarController {
    private final BarService service;

    public BarController(BarService service) {
        this.service = service;
    }

    @GetMapping("/bars/{id}")
    public BarResponseDto getBarById(@PathVariable Long id) {
        return BarUtil.responseDto(service.get(id));
    }

    @PostMapping("/bars")
    public Long createBar(@RequestBody BarRequestDto barRequestDto) {
        return service.create(BarUtil.requestDto(barRequestDto));
    }

    @PutMapping("/bars/{id}")
    public BarResponseDto barResponseDto(@PathVariable Long id, @RequestBody Map<Object, Object> fields) {
        return BarUtil.responseDto(service.update(id, fields));
    }
}
