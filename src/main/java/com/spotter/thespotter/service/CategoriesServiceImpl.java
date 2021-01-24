package com.spotter.thespotter.service;

import com.spotter.thespotter.database.entity.FoodCategories;
import com.spotter.thespotter.database.repository.CategoriesRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesServiceImpl implements CategoriesService {

  @Autowired
  private CategoriesRepository repository;

  @Override
  public Iterable<FoodCategories> getAll() {
    return repository.findAllActive();
  }

  @Override
  @Transactional
  public void create(String name) {
    Optional<FoodCategories> existing = repository.findByCatName(name);
    FoodCategories entity = existing.isPresent() ? existing.get() : new FoodCategories();

    entity.setCatName(name);
    entity.setDeleteFlag("N");

    repository.save(entity);
  }

  @Override
  @Transactional
  public Integer delete(List<Long> ids) {
    List<FoodCategories> existing = repository.findByIds(ids);

    existing.forEach(c -> {
      c.setDeleteFlag("Y");
    });

    repository.saveAll(existing);

    return existing.size();

  }

}
