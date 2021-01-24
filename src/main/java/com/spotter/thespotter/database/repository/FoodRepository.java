package com.spotter.thespotter.database.repository;

import com.spotter.thespotter.database.entity.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends PagingAndSortingRepository<Food, Long> {

  Iterable<Food> findByFoodDescriptionNameContaining(String name);

  Food findDistinctById(Long id);

  @Query("SELECT f FROM Food f WHERE (?1 is null OR  ?1 = '' OR f.foodDescription.name like '%' || ?1 || '%') AND (?2 is null OR f.foodCategory.id = ?2) ANd f.deleteFlag = 'N'")
  Page<Food> getByFoodNameAndCategoryId(String name, Long categoryId, Pageable pageable);


}
