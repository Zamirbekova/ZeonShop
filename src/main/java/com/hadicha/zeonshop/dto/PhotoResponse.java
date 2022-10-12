package com.hadicha.zeonshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotoResponse {
    private Long fileId;
    private String fileType;
    private String message;
    private boolean uploadStatus;
    private String downloadUri;
}
