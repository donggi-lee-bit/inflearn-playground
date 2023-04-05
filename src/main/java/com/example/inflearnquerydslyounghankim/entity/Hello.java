package com.example.inflearnquerydslyounghankim.entity;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Hello {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

}
