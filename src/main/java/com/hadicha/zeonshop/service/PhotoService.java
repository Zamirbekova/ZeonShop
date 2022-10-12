package com.hadicha.zeonshop.service;

import com.hadicha.zeonshop.dto.PhotoResponse;
import com.hadicha.zeonshop.entity.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PhotoService {
    Photo uploadToDb(MultipartFile file,Long commodityId);

    Photo update(MultipartFile file, Long fileId);

    void delete(Long id);

    PhotoResponse getById(Long id);

    List<Photo> findAll();
}
