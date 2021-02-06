package com.spotter.thespotter.model;

import com.spotter.thespotter.database.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserModel {

  private String name;
  private String givenName;
  private String mail;
  private String pictureUrl;
  private User user;

}
