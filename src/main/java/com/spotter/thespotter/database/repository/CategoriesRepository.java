package com.spotter.thespotter.database.repository;

import com.spotter.thespotter.database.entity.FoodCategories;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CategoriesRepository extends CrudRepository<FoodCategories, Long> {

  @Query("SELECT c FROM FoodCategories c WHERE coalesce(c.deleteFlag, 'N') = 'N'")
  List<FoodCategories> findAllActive();

  @Query("SELECT c FROM FoodCategories c WHERE c.catName = :catName")
  Optional<FoodCategories> findByCatName(@Param("catName") String catName);

  @Query("SELECT c FROM FoodCategories c WHERE c.id IN :ids")
  List<FoodCategories> findByIds(@Param("ids") List<Long> ids);
}
