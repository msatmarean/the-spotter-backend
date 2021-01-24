package com.spotter.thespotter.database.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User implements Serializable {

  static final long serialVersionUID = -2487901655437956732L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userid;

  @NotNull
  private String idpUserId;

  private double proteinGoal;
  private double carbsGoal;
  private double fatsGoal;
}
