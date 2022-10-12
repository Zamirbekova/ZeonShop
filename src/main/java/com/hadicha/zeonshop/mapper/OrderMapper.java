package com.hadicha.zeonshop.mapper;

import com.hadicha.zeonshop.dto.OrderRequest;
import com.hadicha.zeonshop.dto.OrderResponse;
import com.hadicha.zeonshop.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper extends AbstractMapper<Order, OrderResponse> {
    public OrderMapper() {
        super(Order.class,OrderResponse.class);
    }
    public Order save(OrderRequest request){
        Order order=new Order();
        order.setAgree(request.isAgree());
        order.setCity(request.getCity());
        order.setCountry(request.getCountry());
        order.setEmail(request.getEmail());
        order.setName(request.getName());
        order.setPhoneNumber(request.getPhoneNumber());
        order.setSurName(request.getSurName());
        return order;
    }
}
