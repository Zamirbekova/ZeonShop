package com.hadicha.zeonshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "public")
@Getter
@Setter
public class Public {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public_seq")
    @SequenceGenerator(name = "public_seq", sequenceName = "public_s")
    @Column(name = "id", nullable = false)
    private Long id;
    private String text;
}
