package com.spotter.thespotter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestModel {
  private double calloriesGoal;
  private double proteinsGoal;
  private double carbsGoal;
  private double fatsGoal;
}
