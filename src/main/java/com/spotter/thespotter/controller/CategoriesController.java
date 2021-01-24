package com.spotter.thespotter.controller;

import com.spotter.thespotter.database.entity.FoodCategories;
import com.spotter.thespotter.service.CategoriesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*")
public class CategoriesController {

  @Autowired
  CategoriesService service;

  @RequestMapping("/getAll")
  public Iterable<FoodCategories> read() {
    return service.getAll();
  }

  @PostMapping("/create")
  public void create(@RequestParam String name) {
    service.create(name);
  }

  @PutMapping("/delete")
  public void delete(@RequestBody List<Long> ids) {
    service.delete(ids);
  }

}
