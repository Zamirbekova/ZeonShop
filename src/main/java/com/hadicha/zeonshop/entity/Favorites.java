package com.hadicha.zeonshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "favorites")
@Getter
@Setter
public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fav_seq")
    @SequenceGenerator(name = "fav_seq", sequenceName = "favor_seq")
    private Long id;
    private Long commodityId;
}
