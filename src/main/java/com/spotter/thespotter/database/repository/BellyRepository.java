package com.spotter.thespotter.database.repository;

import com.spotter.thespotter.database.entity.Belly;
import java.sql.Timestamp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BellyRepository extends CrudRepository<Belly, Long> {

  Iterable<Belly> findByConsumedBetween(Timestamp form, Timestamp to);

  @Query("SELECT b FROM Belly b WHERE b.food.id = :foodId")
  Iterable<Belly> findByFoodId(@Param("foodId") Long foodId);

  @Query("SELECT b FROM Belly b WHERE b.user.idpUserId = :idpUserId AND DATE(b.consumed) = DATE(:date)")
  Iterable<Belly> findByUserAndDate(@Param("idpUserId") String idpUserId, @Param("date") Timestamp date);
}
