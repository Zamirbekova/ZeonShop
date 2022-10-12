package com.hadicha.zeonshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "news")
@Getter
@Setter
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "new_seq")
    @SequenceGenerator(name = "new_seq", sequenceName = "news_s")
    private Long id;
    private String team;
    private String news;
}
