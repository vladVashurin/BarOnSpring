package com.vld.util;

import com.vld.controller.dto.AlcoholRequestDto;
import com.vld.controller.dto.AlcoholResponseDto;
import com.vld.model.Alcohol;

public class AlcoholUtil {
    public static Alcohol requestDto(AlcoholRequestDto alcoholRequestDto) {
        return new Alcohol(alcoholRequestDto.getName(), alcoholRequestDto.getAlcoholType());
    }

    public static AlcoholResponseDto responseDto(Alcohol alcohol) {
        return new AlcoholResponseDto(alcohol.getAlcoholId(), alcohol.getName(), alcohol.getAlcoholType());
    }
}
