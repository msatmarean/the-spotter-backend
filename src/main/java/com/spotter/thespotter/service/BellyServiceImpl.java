package com.spotter.thespotter.service;

import com.spotter.thespotter.database.entity.Belly;
import com.spotter.thespotter.database.entity.Food;
import com.spotter.thespotter.database.entity.User;
import com.spotter.thespotter.database.repository.BellyRepository;
import com.spotter.thespotter.database.repository.FoodRepository;
import com.spotter.thespotter.database.repository.UserRepository;
import com.spotter.thespotter.exceptions.BusineessException;
import com.spotter.thespotter.model.BellyAddRequestModel;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BellyServiceImpl implements BellyService {

  @Autowired
  private BellyRepository bellyRepository;

  @Autowired
  private FoodRepository foodRepository;;

  @Autowired
  private UserService userService;

  @Autowired
  private UserRepository userRepository;


  @Override
  public Belly eat(BellyAddRequestModel request) {

    User user = userRepository.findByUserIdpId(userService.getCurrentUserId())
        .orElseThrow(() -> new BusineessException("user does not exist", HttpStatus.BAD_REQUEST));

    Food food = foodRepository.findById(request.getFoodId()).orElseThrow(() -> new BusineessException("food does not exist", HttpStatus.BAD_REQUEST));

    Belly belly = new Belly();

    belly.setFood(food);
    belly.setQty(request.getQty());
    belly.setConsumed(request.getConsumed());
    belly.setUser(user);

    return bellyRepository.save(belly);
  }

  @Override
  public void delete(Long id) {
    bellyRepository.deleteById(id);

  }

  @Override
  public Iterable<Belly> findAll() {
    return bellyRepository.findAll();
  }

  @Override
  public Iterable<Belly> findByTimestamp(Long from, Long to) {

    return bellyRepository.findByConsumedBetween(toTimestamp(from), toTimestamp(to));
  }

  private Timestamp toTimestamp(Long time) {
    return time == null ? null : new Timestamp(time);
  }

  @Override
  public Belly findById(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Iterable<Belly> findByUserNameAndDate(Long date) {
    return bellyRepository.findByUserAndDate(userService.getCurrentUserId(), new Timestamp(date));
  }
}
