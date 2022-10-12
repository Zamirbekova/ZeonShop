package com.hadicha.zeonshop.dto;

import com.hadicha.zeonshop.entity.Photo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommodityResponse {
    private Long id;
    private String name;
    private String colour;
    private String about;
    private String vendorCode;
    private Long size;
    private Long amount;
    private String fabricComposition;
    private String material;
    private boolean hit;
    private Long currentPrice;
    private Long pricePercent;
    private Long percent;
    private boolean isNew;
    private Photo photo;
}
