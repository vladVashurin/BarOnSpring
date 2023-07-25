package com.vld.service;

import com.vld.model.AlcoholType;

import java.util.List;
import java.util.Map;

public interface AlcoholTypeService {

    AlcoholType get(Long id);

    List<AlcoholType> getAll();

    Long create(AlcoholType alcoholType);

    AlcoholType update(Long alcoholTypeId, Map<Object, Object> fields);

    AlcoholType delete(Long id);
}