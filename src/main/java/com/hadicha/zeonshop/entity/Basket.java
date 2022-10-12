package com.hadicha.zeonshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "basket")
@Getter
@Setter
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "basket_seq")
    @SequenceGenerator(name = "basket_seq", sequenceName = "bas_seq")
    private Long id;
    private Long commodityId;


}
