package com.vld.service;

import com.vld.model.Alcohol;
import org.springframework.stereotype.Service;

import java.util.List;
public interface MenuService {

    List<Alcohol> getBarAlcohol(Long barId);

    void addAlcoholToBar(Long barId, Long alcoholId);

    void deleteAlcoholFromBar(Long barId, Long alcoholId);
}