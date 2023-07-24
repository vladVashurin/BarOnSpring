package com.vld.service.impl;

import com.vld.exceptions.NotFoundException;
import com.vld.model.Bar;
import com.vld.repository.BarRepository;
import com.vld.service.BarService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class BarServiceImpl implements BarService {

    private final BarRepository barRepository;

    @Autowired
    public BarServiceImpl(BarRepository barRepository) {
        this.barRepository = barRepository;
    }

    @Override
    public Bar get(Long id) {
        return barRepository.findById(id).orElseThrow(() -> new NotFoundException("Unable to find alcoholType with id " + id));
    }

    @Override
    public List<Bar> getAll() {
        return (List<Bar>) barRepository.findAll();
    }

    @Transactional
    @Override
    public Long create(Bar bar) {
        return barRepository.save(bar).getBarId();
    }

    @Transactional
    @Override
    public Bar update(Long barId, Map<Object, Object> fields) {
        Bar bar = get(barId);
        fields.forEach((key, value) -> {
            if (!key.equals("barId")) {
                Field field = ReflectionUtils.findField(Bar.class, (String) key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bar, value);
            }
        });
        return barRepository.save(bar);
    }

    @Transactional
    @Override
    public Bar delete(Long id) {
        Bar bar = get(id);
        barRepository.deleteById(id);
        return bar;
    }
}
