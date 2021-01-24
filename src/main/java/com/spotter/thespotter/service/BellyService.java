package com.spotter.thespotter.service;

import com.spotter.thespotter.database.entity.Belly;
import com.spotter.thespotter.model.BellyAddRequestModel;

public interface BellyService {

  Belly eat(BellyAddRequestModel request);

  void delete(Long id);

  Iterable<Belly> findAll();

  Iterable<Belly> findByTimestamp(Long from, Long to);

  Belly findById(Long id);

  Iterable<Belly> findByUserNameAndDate(Long date);
}
