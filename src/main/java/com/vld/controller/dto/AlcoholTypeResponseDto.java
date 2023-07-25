package com.vld.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class AlcoholTypeResponseDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("strength")
    private Double strength;

    public void setId(Long id) {
        this.id = id;
    }
}
