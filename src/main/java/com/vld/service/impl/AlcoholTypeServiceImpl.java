package com.vld.service.impl;

import com.vld.exceptions.NotFoundException;
import com.vld.model.AlcoholType;
import com.vld.repository.AlcoholTypeRepository;
import com.vld.service.AlcoholTypeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class AlcoholTypeServiceImpl implements AlcoholTypeService {

    private final AlcoholTypeRepository alcoholTypeRepository;

    @Autowired
    public AlcoholTypeServiceImpl(AlcoholTypeRepository alcoholTypeRepository) {
        this.alcoholTypeRepository = alcoholTypeRepository;
    }

    @Override
    public AlcoholType get(Long id) {
        return alcoholTypeRepository.findById(id).orElseThrow(() -> new NotFoundException("Unable to find alcoholType with id " + id));
    }

    @Override
    public List<AlcoholType> getAll() {
        List<AlcoholType> alcoholTypeList = (List<AlcoholType>) alcoholTypeRepository.findAll();
        return alcoholTypeList;
    }

    @Transactional
    @Override
    public Long create(AlcoholType alcoholType) {
        return alcoholTypeRepository.save(alcoholType).getAlcoholTypeId();
    }

    @Transactional
    @Override
    public AlcoholType update(Long alcoholTypeId, Map<Object, Object> fields) {
        AlcoholType alcoholType = get(alcoholTypeId);
        fields.forEach((key, value) -> {
            if (!key.equals("alcoholTypeId")) {
                Field field = ReflectionUtils.findField(AlcoholType.class, (String) key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, alcoholType, value);
            }
        });
        return alcoholTypeRepository.save(alcoholType);
    }

    @Transactional
    @Override
    public AlcoholType delete(Long id) {
        AlcoholType alcoholType = get(id);
        alcoholTypeRepository.deleteById(id);
        return alcoholType;
    }
}
