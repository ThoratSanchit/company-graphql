package com.example.company.service.Impl;

import com.example.company.entity.Company;
import com.example.company.repository.CompanyRepository;
import com.example.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }



    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }
    @Override
    public Company updateCompany(Long id, Company company) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()) {
            Company existingCompany = optionalCompany.get();
            existingCompany.setCompanyName(company.getCompanyName());
            existingCompany.setCeo(company.getCeo());
            existingCompany.setFounder(company.getFounder());
            existingCompany.setCo_founder(company.getCo_founder());
            existingCompany.setIndustryType(company.getIndustryType());
            existingCompany.setTotalValuation(company.getTotalValuation());
            return companyRepository.save(existingCompany);
        } else {
            throw new RuntimeException("Company not found with id: " + id);
        }
    }

    @Override
    public boolean deleteCompany(Long id) {

        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));
         companyRepository.delete(company);
         return  true;
    }

    @Override
   public Company getSingleCompany(Long id){
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));
       return company;

    }
}
