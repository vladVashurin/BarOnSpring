package com.vld.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vld.model.Alcohol;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BarResponseDto {
    @JsonProperty("id")
    private Long barId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private String address;
    @JsonProperty("alcoholList")
    List<Alcohol> alcoholList;
}
