package com.spotter.thespotter.database.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Belly implements Serializable {

  private static final long serialVersionUID = 8090415567668556185L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  private Food food;
  private Double qty;
  private Timestamp consumed;
  @ManyToOne
  private User user;

}
