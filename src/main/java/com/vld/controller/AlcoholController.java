package com.vld.controller;

import com.vld.controller.dto.AlcoholRequestDto;
import com.vld.controller.dto.AlcoholResponseDto;
import com.vld.service.AlcoholService;
import com.vld.util.AlcoholUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AlcoholController {
    private final AlcoholService service;

    public AlcoholController(AlcoholService service) {
        this.service = service;
    }

    @GetMapping("/alcohols/{id}")
    public AlcoholResponseDto getById(@PathVariable Long id) {
        return AlcoholUtil.responseDto(service.get(id));
    }

    @PostMapping("/alcohols")
    public Long createAlcohol(@RequestBody AlcoholRequestDto alcoholRequestDto) {
        return AlcoholUtil.requestDto(alcoholRequestDto).getAlcoholId();
    }

    @PutMapping("/alcohols/{id}")
    public AlcoholResponseDto updateAlcohol(@PathVariable Long id, @RequestBody Map<Object, Object> fields) {
        return AlcoholUtil.responseDto(service.update(id, fields));
    }

    @DeleteMapping("/alcohols/{id}")
    public AlcoholResponseDto deleteAlcohol(@PathVariable Long id) {
        return AlcoholUtil.responseDto(service.delete(id));
    }
}
