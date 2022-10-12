package com.hadicha.zeonshop.mapper;

import com.hadicha.zeonshop.dto.PublicRequest;
import com.hadicha.zeonshop.dto.PublicResponse;
import com.hadicha.zeonshop.entity.Public;
import org.springframework.stereotype.Component;

@Component
public class PublicMapper extends AbstractMapper<Public, PublicResponse> {
    public PublicMapper() {
        super(Public.class,PublicResponse.class);
    }
    public Public save(PublicRequest request){
        Public pub=new Public();
        pub.setText(request.getText());
        return pub;
    }
}
