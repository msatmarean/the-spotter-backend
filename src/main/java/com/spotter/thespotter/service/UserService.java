package com.spotter.thespotter.service;

import com.spotter.thespotter.database.entity.User;
import com.spotter.thespotter.model.UserModel;
import com.spotter.thespotter.model.UserRequestModel;

public interface UserService {

  public String getCurrentUserId();

  public UserModel getUserModel();

  public void setOrCreateUserModel(UserRequestModel request);

  public User getCurrentUserEntity();

}
