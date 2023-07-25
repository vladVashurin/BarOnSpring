package com.vld.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vld.model.AlcoholType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AlcoholResponseDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("alcoholType")
    private AlcoholType alcoholType;
}
