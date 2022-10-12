package com.hadicha.zeonshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "social_network")
@Getter
@Setter
public class SocialNetwork {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "social_seq")
    @SequenceGenerator(name = "social_seq", sequenceName = "soc_seq")
    private Long id;
    private String instagram;
    private String telegram;
    private String whatsUpp;


}
