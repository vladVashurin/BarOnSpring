package com.vld.controller.dto;

import com.vld.model.AlcoholType;
import lombok.Getter;

@Getter
public class AlcoholRequestDto {
    private String name;
    private AlcoholType alcoholType;
}
