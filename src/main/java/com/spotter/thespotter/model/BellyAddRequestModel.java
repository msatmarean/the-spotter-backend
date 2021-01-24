package com.spotter.thespotter.model;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BellyAddRequestModel {
  private Long foodId;
  private Double qty;
  private Timestamp consumed;
}
