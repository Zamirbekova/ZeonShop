package com.hadicha.zeonshop.service.impl;

import com.hadicha.zeonshop.dto.PhotoResponse;
import com.hadicha.zeonshop.entity.Commodity;
import com.hadicha.zeonshop.entity.Photo;
import com.hadicha.zeonshop.exceptions.NotFoundException;
import com.hadicha.zeonshop.mapper.PhotoMapper;
import com.hadicha.zeonshop.repository.CommodityRepository;
import com.hadicha.zeonshop.repository.PhotoRepository;
import com.hadicha.zeonshop.service.PhotoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepository fileUploadRepository;
    private final PhotoMapper mapper;
    private final CommodityRepository commodityRepository;

    @Override
    public Photo uploadToDb(MultipartFile file,Long commodityId) {
        Photo uploadedFile = new Photo();
        Commodity commodity=commodityRepository.findById(commodityId).orElseThrow(()->new NotFoundException("not"));
        commodity.setPhoto(uploadedFile);
        uploadedFile.setCommodity(commodity.getId());
        try {
            uploadedFile.setFileData(file.getBytes());
            uploadedFile.setFileType(file.getContentType());
            uploadedFile.setFileName(file.getOriginalFilename());
            return fileUploadRepository.save(uploadedFile);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Photo update(MultipartFile file, Long fileId) {
        Photo uploadBusinessFile = fileUploadRepository.findById(fileId).get();

        try {
            uploadBusinessFile.setFileData(file.getBytes());
            uploadBusinessFile.setFileType(file.getContentType());
            uploadBusinessFile.setFileName(file.getOriginalFilename());
            return fileUploadRepository.save(uploadBusinessFile);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void delete(Long id) {
        fileUploadRepository.deleteById(id);
    }

    @Override
    public PhotoResponse getById(Long id) {
        return mapper.toDto(fileUploadRepository.findById(id).orElseThrow(() -> new NotFoundException("not found")));
    }

    @Override
    public List<Photo> findAll() {
        return fileUploadRepository.findAll();
    }


}

