package com.example.company.service;

import com.example.company.entity.Company;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CompanyService {
    Company createCompany(Company company);


    Company getSingleCompany(Long id);

    //getAll

    List<Company> getAll();

    //update

    Company updateCompany(Long id,Company company);

    //delete
     boolean deleteCompany(Long id);


}
