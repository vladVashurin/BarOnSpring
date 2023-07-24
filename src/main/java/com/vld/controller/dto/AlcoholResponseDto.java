package com.vld.controller.dto;

import com.vld.model.AlcoholType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AlcoholResponseDto {
    private Long id;
    private String name;
    private AlcoholType alcoholType;
}
