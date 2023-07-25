package com.vld.controller.dto;

import com.vld.model.Alcohol;
import lombok.Getter;

import java.util.List;

@Getter
public class BarRequestDto {
    private String name;
    private String address;
    List<Alcohol> alcoholList;
}
