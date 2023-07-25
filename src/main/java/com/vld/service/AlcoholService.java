package com.vld.service;

import com.vld.model.Alcohol;

import java.util.List;
import java.util.Map;

public interface AlcoholService {

    Alcohol get(Long id);

    List<Alcohol> getAll();

    Long create(Alcohol alcohol);

    Alcohol update(Long alcoholId, Map<Object, Object> fields);

    Alcohol delete(Long id);
}