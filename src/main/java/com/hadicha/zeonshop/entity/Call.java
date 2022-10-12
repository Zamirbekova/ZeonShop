package com.hadicha.zeonshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "call")
@Getter
@Setter
public class Call {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "call_seq")
    @SequenceGenerator(name = "call_seq", sequenceName = "call_se")
    private Long id;
    private String name;
    private String phoneNumber;
}
