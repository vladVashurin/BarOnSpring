package com.vld.service;

import com.vld.model.Bar;

import java.util.List;
import java.util.Map;

public interface BarService {

    Bar get(Long id);

    List<Bar> getAll();

    Long create(Bar bar);

    Bar update(Long barId, Map<Object, Object> fields);

    Bar delete(Long id);
}