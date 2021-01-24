package com.spotter.thespotter.service;

import com.spotter.thespotter.database.entity.FoodCategories;
import java.util.List;

public interface CategoriesService {

  public Iterable<FoodCategories> getAll();

  public void create(String name);

  public Integer delete(List<Long> ids);
}
