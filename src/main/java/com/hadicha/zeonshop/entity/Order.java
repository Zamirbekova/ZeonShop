package com.hadicha.zeonshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "order_se")
    private Long id;
    private String name;
    private String surName;
    private String email;
    private String phoneNumber;
    private String country;
    private String city;
    private boolean agree;

}
