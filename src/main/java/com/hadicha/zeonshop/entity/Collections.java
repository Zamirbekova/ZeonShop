package com.hadicha.zeonshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "collections")
@Getter
@Setter
public class Collections {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "collect_seq")
    @SequenceGenerator(name = "collect_seq", sequenceName = "coll_seq", allocationSize = 1)
    private Long id;
    private String collections;
}
