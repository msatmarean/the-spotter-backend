package com.spotter.thespotter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserModel extends UserRequestModel {

  private String name;
  private String givenName;
  private String mail;
  private String pictureUrl;

}
