package com.vld.service.impl;

import com.vld.model.Alcohol;
import com.vld.model.AlcoholType;
import com.vld.model.Bar;
import com.vld.service.AlcoholService;
import com.vld.service.AlcoholTypeService;
import com.vld.service.BarService;
import com.vld.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuServiceImplTest {
    @Autowired
    BarService barService;

    @Autowired
    AlcoholTypeService alcoholTypeService;

    @Autowired
    AlcoholService alcoholService;

    @Autowired
    MenuService menuService;
    AlcoholType alcoholType = new AlcoholType(50d);
    Alcohol alcohol = new Alcohol("Водка", alcoholType);
    Bar bar = new Bar("Паб", "улица Ленина, дом 7", List.of(alcohol));

    private Bar getBar() {
        alcoholTypeService.create(alcoholType);
        alcoholService.create(alcohol);
        return bar;
    }

    @Test
    public void getBarAlcohol() {
        Long id = barService.create(getBar());
        assertTrue(getBar().getAlcoholList().containsAll(menuService.getBarAlcohol(id)));
    }

    @Test
    public void addAlcoholToBar() {
        AlcoholType aclType = new AlcoholType(8d);
        Alcohol alc = new Alcohol("Пиво", aclType);
        alcoholTypeService.create(aclType);
        Long alcId = alcoholService.create(alc);
        Long barId = barService.create(getBar());
        Alcohol actAlc = alcoholService.get(alcId);
        menuService.addAlcoholToBar(barId, alcId);
        assertTrue(menuService.getBarAlcohol(barId).contains(actAlc));
    }

    @Test
    public void deleteAlcoholFromBar() {
        AlcoholType aclType = new AlcoholType(8d);
        Alcohol alc = new Alcohol("Пиво", aclType);
        alcoholTypeService.create(aclType);
        Long alcId = alcoholService.create(alc);
        Long barId = barService.create(getBar());
        menuService.addAlcoholToBar(barId, alcId);
        int expected = menuService.getBarAlcohol(barId).size() - 1;
        menuService.deleteAlcoholFromBar(barId, alcId);
        assertEquals(expected, menuService.getBarAlcohol(barId).size());
    }
}