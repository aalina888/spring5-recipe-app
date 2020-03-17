package com.aalina.spring5recipeapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount;
    //todo
    //primate UnitOfMeasure uom;

    @ManyToOne
    private Recipe recipe;
}
