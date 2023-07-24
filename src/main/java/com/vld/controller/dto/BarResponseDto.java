package com.vld.controller.dto;

import com.vld.model.Alcohol;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BarResponseDto {
    private Long barId;
    private String name;
    private String address;
    List<Alcohol> alcoholList;
}
