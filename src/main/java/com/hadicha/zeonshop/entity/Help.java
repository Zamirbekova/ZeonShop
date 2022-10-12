package com.hadicha.zeonshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "help")
@Getter
@Setter
public class Help {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "help_seq")
    @SequenceGenerator(name = "help_seq", sequenceName = "hel_seq")
    private Long id;
    private String questions;
    private String answer;

}
