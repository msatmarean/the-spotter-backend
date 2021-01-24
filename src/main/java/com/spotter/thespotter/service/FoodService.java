package com.spotter.thespotter.service;

import com.spotter.thespotter.database.entity.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FoodService {

  Food save(Food food);

  void deleteById(Long id);

  Iterable<Food> readAll();

  Food readById(Long id);

  Iterable<Food> findByName(String name);

  void update(Food food) throws Exception;

  Page<Food> findByNameAndCategoryId(String name, Long categoryId, Pageable pageable);
}
