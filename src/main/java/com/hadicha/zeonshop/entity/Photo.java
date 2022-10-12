package com.hadicha.zeonshop.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "photo")
@Getter
@Setter
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "photo_seq")
    @SequenceGenerator(name = "photo_seq", sequenceName = "photo_se", allocationSize = 1)
    private Long id;
    private String fileName;
    private String fileType;
    @Type(type = "org.hibernate.type.ImageType")
    private byte[] fileData;
    private Long commodity;
}
