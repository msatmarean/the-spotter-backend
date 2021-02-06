package com.spotter.thespotter.database.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Food implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private double proteins;
  private double fats;
  private double carbs;
  private double fiber;
  private double calories;
  private double gramsPerServing;
  @Column(length = 1)
  private String deleteFlag;

  @ManyToOne(cascade = {CascadeType.ALL})
  private User owner;

  @OneToOne
  @JoinColumn(name = "catId")
  private FoodCategories foodCategory;

  @Embedded
  @OneToOne(cascade = {CascadeType.ALL})
  private FoodDescription foodDescription;

}
