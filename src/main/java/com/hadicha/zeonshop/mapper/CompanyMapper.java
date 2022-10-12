package com.hadicha.zeonshop.mapper;

import com.hadicha.zeonshop.dto.CompanyRequest;
import com.hadicha.zeonshop.dto.CompanyResponse;
import com.hadicha.zeonshop.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper extends AbstractMapper<Company, CompanyResponse> {
    public CompanyMapper() {
        super(Company.class,CompanyResponse.class);
    }
    public Company save(CompanyRequest companyRequest){
        Company company=new Company();
        company.setAbout(companyRequest.getAbout());
        return company;
    }
}
