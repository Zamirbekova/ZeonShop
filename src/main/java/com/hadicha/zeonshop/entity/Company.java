package com.hadicha.zeonshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
    @SequenceGenerator(name = "company_seq", sequenceName = "company_gen")
    private Long id;
    private String about;
    @OneToMany
    private List<News> news;
    @OneToMany
    private List<Help> help;
}
