package com.spotter.thespotter.controller;

import com.spotter.thespotter.database.entity.Belly;
import com.spotter.thespotter.model.BellyAddRequestModel;
import com.spotter.thespotter.service.BellyService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/belly")
@CrossOrigin(origins = "*")
@Slf4j
public class BellyController {

  Logger logger = LoggerFactory.getLogger(BellyController.class);

  @Autowired
  private BellyService bellyService;

  @PostMapping("/add")
  public Belly create(@RequestBody BellyAddRequestModel request) {
    return bellyService.eat(request);
  }

  @GetMapping("/delete")
  public void delete(@RequestParam("id") Long id) {
    bellyService.delete(id);
  }

  @GetMapping("/getAll")
  public Iterable<Belly> getAll() {

    return bellyService.findAll();
  }

  @GetMapping("/consumedOn")
  public Iterable<Belly> findByUserNameAndDate(@RequestParam("date") Long date) {
    return bellyService.findByUserNameAndDate(date);
  }
}
