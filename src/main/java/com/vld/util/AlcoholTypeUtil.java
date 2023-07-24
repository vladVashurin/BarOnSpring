package com.vld.util;

import com.vld.controller.dto.AlcoholTypeRequestDto;
import com.vld.controller.dto.AlcoholTypeResponseDto;
import com.vld.model.AlcoholType;

public class AlcoholTypeUtil {
    public static AlcoholType requestDto(AlcoholTypeRequestDto alcoholTypeRequestDto){
        return new AlcoholType(alcoholTypeRequestDto.getStrength());
    }
    public static AlcoholTypeResponseDto responseDto(AlcoholType alcoholType){
       return new AlcoholTypeResponseDto(alcoholType.getAlcoholTypeId(), alcoholType.getStrength());
    }
}
