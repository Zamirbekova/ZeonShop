package com.hadicha.zeonshop.dto;

import com.hadicha.zeonshop.entity.Help;
import com.hadicha.zeonshop.entity.News;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompanyResponse {
    private Long id;
    private String about;
    private List<News> news;
    private List<Help> help;
}
