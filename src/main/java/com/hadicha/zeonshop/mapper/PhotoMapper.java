package com.hadicha.zeonshop.mapper;

import com.hadicha.zeonshop.dto.PhotoResponse;
import com.hadicha.zeonshop.entity.Photo;
import org.springframework.stereotype.Component;

@Component
public class PhotoMapper extends AbstractMapper<Photo, PhotoResponse> {
    public PhotoMapper() {
        super(Photo.class, PhotoResponse.class);
    }

}
