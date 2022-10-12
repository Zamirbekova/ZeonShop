package com.hadicha.zeonshop.controller;

import com.hadicha.zeonshop.dto.PhotoResponse;
import com.hadicha.zeonshop.entity.Photo;
import com.hadicha.zeonshop.service.PhotoService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/photo")
public class PhotoController {
    private final PhotoService service;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @PostMapping(consumes = {"multipart/form-data"} ,value = "/{id}")
    public PhotoResponse uploadDb(@RequestParam("file") MultipartFile multipartFile,@PathVariable Long id) {
        Photo uploadedFile = service.uploadToDb(multipartFile,id);
        PhotoResponse response = new PhotoResponse();
        if (uploadedFile != null) {
            String downloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/v1/download/")
                    .path(String.valueOf(uploadedFile.getId()))
                    .toUriString();
            response.setDownloadUri(downloadUri);
            response.setFileId(uploadedFile.getId());
            response.setFileType(uploadedFile.getFileType());
            response.setUploadStatus(true);
            response.setMessage("File Uploaded Successfully!");
            return response;

        }
        response.setMessage("Oops 1 something went wrong please re-upload.");
        return response;
    }

    @PutMapping(consumes = {"multipart/form-data"}, value = "/{fileId}")
    public PhotoResponse update(@RequestParam("file") MultipartFile multipartFile, @PathVariable String id, @PathVariable Long fileId) {
        Photo uploadedFile = service.update(multipartFile, fileId);
        PhotoResponse response = new PhotoResponse();
        if (uploadedFile != null) {
            String downloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/v1/download/")
                    .path(String.valueOf(uploadedFile.getId()))
                    .toUriString();
            response.setDownloadUri(downloadUri);
            response.setFileId(uploadedFile.getId());
            response.setFileType(uploadedFile.getFileType());
            response.setUploadStatus(true);
            response.setMessage("File Uploaded Successfully!");
            return response;

        }
        response.setMessage("Oops 1 something went wrong please re-upload.");
        return response;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("{id}")
    public PhotoResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Photo> getAllPhotos() {
        return service.findAll();
    }
}



