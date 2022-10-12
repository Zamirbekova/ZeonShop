package com.hadicha.zeonshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "commodity")
@Getter
@Setter
public class Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comm_seq")
    @SequenceGenerator(name = "comm_seq", sequenceName = "comm_s")
    private Long id;
    private String name;
    private String colour;
    private String about;
    private String vendorCode;
    private Long size;
    private Long amount;
    private String fabricComposition;
    private String material;
    private boolean hit;
    private boolean isNew;
    private int currentPrice;
    private double pricePercent;
    private double percent;
    @OneToOne
    private Photo photo;
}
