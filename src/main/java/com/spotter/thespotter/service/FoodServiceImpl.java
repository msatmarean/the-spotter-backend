package com.spotter.thespotter.service;

import com.spotter.thespotter.database.entity.Food;
import com.spotter.thespotter.database.entity.FoodCategories;
import com.spotter.thespotter.database.repository.CategoriesRepository;
import com.spotter.thespotter.database.repository.FoodRepository;
import com.spotter.thespotter.exceptions.BusineessException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {

  @Autowired
  private FoodRepository foodRepository;

  @Autowired
  private CategoriesRepository categoriesRepository;
  @Autowired
  private UserService userService;

  @Override
  public Food save(Food food) {

    food.setOwner(userService.getCurrentUserEntity());
    food.setDeleteFlag("N");

    return foodRepository.save(food);
  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    Food food = foodRepository.findById(id).orElseThrow(() -> new BusineessException("Food not found ", HttpStatus.BAD_REQUEST));
    food.setDeleteFlag("Y");
  }

  @Override
  public Iterable<Food> readAll() {
    return foodRepository.findAll();
  }

  @Override
  public Food readById(Long id) {
    return foodRepository.findDistinctById(id);
  }

  @Override
  public Iterable<Food> findByName(String name) {
    return foodRepository.findByFoodDescriptionNameContaining(name);
  }

  @Override
  @Transactional
  public void update(Food food) throws Exception {
    Food foodEntity = foodRepository.findById(food.getId()).orElseThrow(() -> new Exception());
    FoodCategories categoryEntity = categoriesRepository.findById(food.getFoodCategory().getId()).orElseThrow(() -> new Exception());

    foodEntity.setCalories(food.getCalories());
    foodEntity.setCarbs(food.getCarbs());
    foodEntity.setFats(food.getFats());
    foodEntity.setFiber(food.getFiber());
    foodEntity.setProteins(food.getProteins());
    foodEntity.setGramsPerServing(food.getGramsPerServing());
    foodEntity.setFoodCategory(categoryEntity);
    foodEntity.getFoodDescription().setDescription(food.getFoodDescription().getDescription());
    foodEntity.getFoodDescription().setName(food.getFoodDescription().getName());
  }

  @Override
  public Page<Food> findByNameAndCategoryId(String name, Long categoryId, Pageable pageable) {
    return foodRepository.getByFoodNameAndCategoryId(name, categoryId, pageable);
  }

}
