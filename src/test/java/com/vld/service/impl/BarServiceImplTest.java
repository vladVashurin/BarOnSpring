package com.vld.service.impl;

import com.vld.exceptions.NotFoundException;
import com.vld.model.Alcohol;
import com.vld.model.AlcoholType;
import com.vld.model.Bar;
import com.vld.service.AlcoholService;
import com.vld.service.AlcoholTypeService;
import com.vld.service.BarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BarServiceImplTest {
    @Autowired
    BarService service;

    @Autowired
    AlcoholTypeService alcoholTypeService;

    @Autowired
    AlcoholService alcoholService;
    AlcoholType alcoholType = new AlcoholType(50d);
    Alcohol alcohol = new Alcohol("Водка", alcoholType);
    Bar bar = new Bar("Паб", "улица Ленина, дом 7", List.of(alcohol));

    private Bar getBar() {
        alcoholTypeService.create(alcoholType);
        alcoholService.create(alcohol);
        return bar;
    }

    @Test
    public void createAndGetById() {
        Long id = service.create(getBar());
        Bar actual = service.get(id);
        assertEquals(getBar(), actual);
    }

    @Test
    public void getAll() {
        service.create(getBar());
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
        Long id = service.create(getBar());
        Map<Object, Object> map = new HashMap<>();
        String upd = "Пивная";
        map.put("name", upd);
        service.update(id, map);
        assertEquals(upd, service.get(id).getName());
    }

    @Test
    public void delete() {
        Long id = service.create(getBar());
        int expected = service.getAll().size() - 1;
        service.delete(id);
        assertEquals(expected, service.getAll().size());
    }
}