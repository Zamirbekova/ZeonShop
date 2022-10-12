package com.hadicha.zeonshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "contact")
@Getter
@Setter
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cont_seq")
    @SequenceGenerator(name = "cont_seq", sequenceName = "contact_seq")
    private Long id;
    private String phoneNumber;
    private String secondPhoneNumber;
    private String email;


}
