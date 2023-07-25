package com.vld.service.impl;

import com.vld.exceptions.NotFoundException;
import com.vld.model.Alcohol;
import com.vld.model.AlcoholType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlcoholServiceImplTest {
    @Autowired
    AlcoholServiceImpl service;

    @Autowired
    AlcoholTypeServiceImpl alcoholTypeService;

    AlcoholType alcoholType = new AlcoholType(50d);
    Alcohol alcohol = new Alcohol("Водка", alcoholType);

    public Alcohol getAlcohol() {
        alcoholTypeService.create(alcoholType);
        return alcohol;
    }

    @Test
    public void creatAndGetById() {
        Long id = service.create(getAlcohol());
        Alcohol actual = service.get(id);
        assertEquals(alcohol, actual);
    }

    @Test
    public void getAll() {
        service.create(getAlcohol());
        assertFalse(service.getAll().isEmpty());
    }


    @Test(expected = NotFoundException.class)
    public void getNotFoundException() {
        Long id = 1l;
        service.delete(id);
        service.get(id);
    }

    @Test
    public void update() {
        Long id = service.create(getAlcohol());
        Map<Object, Object> map = new HashMap<>();
        String upd = "коньяк";
        map.put("name", upd);
        assertEquals(upd, service.get(id).getName());
    }

    @Test
    public void delete() {
        Long id = service.create(getAlcohol());
        int expected = service.getAll().size() - 1;
        service.delete(id);
        assertEquals(expected, service.getAll().size());
    }
}