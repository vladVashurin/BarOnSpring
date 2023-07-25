package com.vld.service.impl;

import com.vld.controller.dto.AlcoholTypeResponseDto;
import com.vld.exceptions.NotFoundException;
import com.vld.model.AlcoholType;
import com.vld.util.AlcoholTypeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlcoholTypeServiceImplTest {
    @Autowired
    AlcoholTypeServiceImpl service;


    @Test
    public void createAndGetAlcoholById() {
        AlcoholType expected = new AlcoholType(50d);
        Long id = service.create(expected);
        AlcoholType type = service.get(id);
        assertEquals(expected, type);
    }


    @Test(expected = NotFoundException.class)
    public void getNotFoundException() {
        AlcoholType alcoholType = service.delete(1l);
        service.get(alcoholType.getAlcoholTypeId());
    }

    @Test
    public void getAll() {
        AlcoholType alcoholType1 = new AlcoholType(50d);
        AlcoholType alcoholType2 = new AlcoholType(8d);
        service.create(alcoholType1);
        service.create(alcoholType2);
        assertFalse(service.getAll().isEmpty());
    }

    @Test
    public void update() {
        AlcoholType alcoholType = new AlcoholType(50d);
        Long id = service.create(alcoholType);
        Map<Object, Object> map = new HashMap<>();
        map.put("strength", 45d);
        service.update(id, map);
        AlcoholType alcoholTypeUpd = new AlcoholType(45d);
        AlcoholTypeResponseDto alcoholTypeResponseDto = AlcoholTypeUtil.responseDto(alcoholTypeUpd);
        alcoholTypeResponseDto.setId(id);
        assertEquals(alcoholTypeResponseDto, AlcoholTypeUtil.responseDto(service.get(id)));
    }

    @Test
    public void delete() {
        AlcoholType alcoholType = new AlcoholType(50d);
        Long id = service.create(alcoholType);
        int expected = service.getAll().size() - 1;
        service.delete(id);
        assertEquals(expected, service.getAll().size());
    }
}