package com.vld.service.impl;

import com.vld.model.Alcohol;
import com.vld.model.Bar;
import com.vld.service.AlcoholService;
import com.vld.service.BarService;
import com.vld.service.MenuService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private final BarService barService;
    private final AlcoholService alcoholService;

    @Autowired
    public MenuServiceImpl(BarService barService, AlcoholService alcoholService) {
        this.barService = barService;
        this.alcoholService = alcoholService;
    }

    @Override
    public List<Alcohol> getBarAlcohol(Long barId) {
        Bar bar = barService.get(barId);
        List<Alcohol> alcoholList = bar.getAlcoholList();
        return alcoholList;
    }

    @Transactional
    @Override
    public void addAlcoholToBar(Long barId, Long alcoholId) {
        Bar bar = barService.get(barId);
        List<Alcohol> alcoholList = bar.getAlcoholList();
        alcoholList.add(alcoholService.get(alcoholId));
        bar.setAlcoholList(alcoholList);
        barService.create(bar);
    }

    @Transactional
    @Override
    public void deleteAlcoholFromBar(Long barId, Long alcoholId) {
        Bar bar = barService.get(barId);
        List<Alcohol> alcoholList = bar.getAlcoholList();
        alcoholList.remove(alcoholService.get(alcoholId));
        bar.setAlcoholList(alcoholList);
    }
}
