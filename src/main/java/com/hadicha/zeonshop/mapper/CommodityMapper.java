package com.hadicha.zeonshop.mapper;

import com.hadicha.zeonshop.dto.CommodityRequest;
import com.hadicha.zeonshop.dto.CommodityResponse;
import com.hadicha.zeonshop.entity.Commodity;
import org.springframework.stereotype.Component;

@Component
public class CommodityMapper extends AbstractMapper<Commodity,CommodityResponse> {
    public CommodityMapper() {
        super(Commodity.class, CommodityResponse.class);
    }

  public Commodity save(CommodityRequest request) {
        Commodity commodity = new Commodity();
        commodity.setAbout(request.getAbout());
        commodity.setColour(request.getColour());
        commodity.setAmount(request.getAmount());
        commodity.setFabricComposition(request.getFabricComposition());
        commodity.setHit(request.isHit());
        commodity.setNew(request.isNew());
        commodity.setMaterial(request.getMaterial());
        commodity.setName(request.getName());
        commodity.setSize(request.getSize());
        commodity.setVendorCode(request.getVendorCode());
//        commodity.setPercent(request.getPercent());
//        commodity.setPricePercent(request.getPricePercent());
        commodity.setCurrentPrice(request.getCurrentPrice());
        return commodity;
    }
}
