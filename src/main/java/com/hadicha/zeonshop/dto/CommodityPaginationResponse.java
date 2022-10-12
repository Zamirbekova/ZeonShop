package com.hadicha.zeonshop.dto;

import com.hadicha.zeonshop.entity.Commodity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommodityPaginationResponse {
    private int pages;
    private int current_page;
    private List<Commodity> commodityList;
}
