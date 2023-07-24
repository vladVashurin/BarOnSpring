package com.vld.util;

import com.vld.controller.dto.AlcoholResponseDto;
import com.vld.model.Alcohol;

import java.util.ArrayList;
import java.util.List;

public class MenuUtil {
    public static List<AlcoholResponseDto>AlcoholToAlcoholResponseDto(List<Alcohol>alcoholList){
        List<AlcoholResponseDto>list = new ArrayList<>();
        alcoholList.forEach(a->list.add(AlcoholUtil.responseDto(a)));
        return list;
    }
}
