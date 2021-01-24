package com.spotter.thespotter.controller;

import com.spotter.thespotter.database.entity.Food;
import com.spotter.thespotter.service.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foods")
@CrossOrigin(origins = "*")
public class FoodController {

  Logger logger = LoggerFactory.getLogger(FoodController.class);

  @Autowired
  private FoodService service;

  @PostMapping("/create")
  public Food create(@RequestBody Food food) {
    return service.save(food);
  }

  @PutMapping("/update")
  public void upodate(@RequestBody Food food) throws Exception {
    service.update(food);
  }

  @GetMapping("/getAll")
  public Iterable<Food> read() {
    return service.readAll();
  }

  @GetMapping("/get")
  public Food readById(@RequestParam("id") Long id) {
    return service.readById(id);
  }

  @GetMapping("delete")
  public void deleteById(@RequestParam("id") Long id) {
    service.deleteById(id);
  }

  @GetMapping("/findByName")
  public Iterable<Food> findByName(@RequestParam("name") String name) {
    return service.findByName(name);
  }

  @GetMapping("/find")
  public Page<Food> findByNameAndCategory(String name, Long categoryId, Pageable pageable) {
    return service.findByNameAndCategoryId(name, categoryId, pageable);
  }

}
