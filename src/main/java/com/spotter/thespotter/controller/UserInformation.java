package com.spotter.thespotter.controller;

import com.spotter.thespotter.model.UserModel;
import com.spotter.thespotter.model.UserRequestModel;
import com.spotter.thespotter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserInformation {

  @Autowired
  UserService userService;

  @GetMapping("/info")
  public UserModel getUserInformation() {
    return userService.getUserModel();
  }

  @PutMapping("/info")
  public void setUserInformation(@RequestBody UserRequestModel request) {
    userService.setOrCreateUserModel(request);
  }

}
