package com.vld.controller;

import com.vld.controller.dto.AlcoholTypeRequestDto;
import com.vld.controller.dto.AlcoholTypeResponseDto;
import com.vld.service.AlcoholTypeService;
import com.vld.util.AlcoholTypeUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AlcoholTypeController {
    private final AlcoholTypeService service;

    public AlcoholTypeController(AlcoholTypeService service) {
        this.service = service;
    }

    @GetMapping("/alcoholTypes/{id}")
    public AlcoholTypeResponseDto getById(@PathVariable Long id) {
        return AlcoholTypeUtil.responseDto(service.get(id));
    }

    @PostMapping("/alcoholTypes")
    public Long createAlcoholType(@RequestBody AlcoholTypeRequestDto alcoholTypeRequestDto) {
        return service.create(AlcoholTypeUtil.requestDto(alcoholTypeRequestDto));
    }

    @PutMapping("/alcoholTypes/{id}")
    public AlcoholTypeResponseDto updateAlcoholType(@PathVariable Long id, @RequestBody Map<Object, Object> fields) {
        return AlcoholTypeUtil.responseDto(service.update(id, fields));
    }

    @DeleteMapping("/alcoholTypes/{id}")
    public AlcoholTypeResponseDto deleteAlcoholType(@PathVariable Long id) {
        return AlcoholTypeUtil.responseDto(service.delete(id));
    }
}
