package com.vld.repository;

import com.vld.model.Alcohol;
import org.springframework.data.repository.CrudRepository;
public interface AlcoholRepository extends CrudRepository<Alcohol, Long> {
}
