package com.hadicha.zeonshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommodityRequest {
    private String name;
    private String colour;
    private String about;
    private String vendorCode;
    private Long size;
    private Long amount;
    private String fabricComposition;
    private String material;
    private boolean hit;
    private int currentPrice;
    private Long pricePercent;
    private boolean isNew;
    private Long percent;
    
}
