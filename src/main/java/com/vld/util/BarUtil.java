package com.vld.util;

import com.vld.controller.dto.BarRequestDto;
import com.vld.controller.dto.BarResponseDto;
import com.vld.model.Bar;

public class BarUtil {
    public static Bar requestDto(BarRequestDto barRequestDto) {
        return new Bar(barRequestDto.getName(), barRequestDto.getAddress(), barRequestDto.getAlcoholList());
    }

    public static BarResponseDto responseDto(Bar bar) {
        return new BarResponseDto(bar.getBarId(), bar.getName(), bar.getAddress(), bar.getAlcoholList());
    }
}
