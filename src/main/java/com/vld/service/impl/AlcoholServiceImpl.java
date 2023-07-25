package com.vld.service.impl;

import com.vld.exceptions.NotFoundException;
import com.vld.model.Alcohol;
import com.vld.repository.AlcoholRepository;
import com.vld.service.AlcoholService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class AlcoholServiceImpl implements AlcoholService {

    private final AlcoholRepository alcoholRepository;

    @Autowired
    public AlcoholServiceImpl(AlcoholRepository alcoholRepository) {
        this.alcoholRepository = alcoholRepository;
    }

    @Override
    public Alcohol get(Long id) {
        return alcoholRepository.findById(id).orElseThrow(() -> new NotFoundException("Unable to find alcohol with id " + id));
    }

    @Override
    public List<Alcohol> getAll() {
        List<Alcohol> alcoholList = (List<Alcohol>) alcoholRepository.findAll();
        return alcoholList;
    }

    @Transactional
    @Override
    public Long create(Alcohol alcohol) {
        return alcoholRepository.save(alcohol).getAlcoholId();
    }

    @Transactional
    @Override
    public Alcohol update(Long alcoholId, Map<Object, Object> fields) {
        Alcohol alcohol = get(alcoholId);
        fields.forEach((key, value) -> {
            if (!key.equals("alcoholId")) {
                Field field = ReflectionUtils.findField(Alcohol.class, (String) key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, alcohol, value);
            }
        });
        return alcoholRepository.save(alcohol);
    }

    @Transactional
    @Override
    public Alcohol delete(Long id) {
        Alcohol alcohol = get(id);
        alcoholRepository.deleteById(id);
        return alcohol;
    }
}
