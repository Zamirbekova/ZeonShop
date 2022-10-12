package com.hadicha.zeonshop.mapper;

import com.hadicha.zeonshop.dto.SocialNetworkRequest;
import com.hadicha.zeonshop.dto.SocialNetworkResponse;
import com.hadicha.zeonshop.entity.SocialNetwork;
import org.springframework.stereotype.Component;

@Component
public class SocialMapper extends AbstractMapper<SocialNetwork, SocialNetworkResponse> {
    public SocialMapper() {
        super(SocialNetwork.class, SocialNetworkResponse.class);
    }

    public SocialNetwork save(SocialNetworkRequest request) {
        SocialNetwork socialNetwork = new SocialNetwork();
        socialNetwork.setInstagram(request.getInstagram());
        socialNetwork.setTelegram(request.getTelegram());
        socialNetwork.setWhatsUpp(request.getWhatsUpp());
        return socialNetwork;
    }
}
