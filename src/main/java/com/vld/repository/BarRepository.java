package com.vld.repository;

import com.vld.model.Bar;
import org.springframework.data.repository.CrudRepository;

public interface BarRepository extends CrudRepository<Bar, Long> {
}
