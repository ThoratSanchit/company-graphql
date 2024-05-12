package com.example.company.controller;

import com.example.company.entity.Company;
import com.example.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;

import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyCntroller {
    @Autowired
    private CompanyService companyService;
    @MutationMapping
public Company createCompany(@Argument String companyName, @Argument String ceo, @Argument String founder, @Argument String co_founder,@Argument String industryType,@Argument int totalValuation){
Company company=new Company();
company.setCompanyName(companyName);
company.setCeo(ceo);
company.setFounder(founder);
company.setIndustryType(industryType);
company.setTotalValuation(totalValuation);
company.setCo_founder(co_founder);
return  companyService.createCompany(company);

}

@QueryMapping
public List<Company> getAllCompany(){
    return companyService.getAll();
}
@QueryMapping
public Company getSingleCompany(@Argument Long id){
        return companyService.getSingleCompany(id);
  }

  @MutationMapping
    public boolean deleteCompany(@Argument Long id){
        return companyService.deleteCompany(id);
  }

    @MutationMapping
    public Company updateCompany(@Argument Long id, @Argument String companyName, @Argument String ceo, @Argument String founder, @Argument String co_founder, @Argument String industryType, @Argument int totalValuation) {
        Company existingCompany = companyService.getSingleCompany(id);
        if (existingCompany != null) {
            existingCompany.setCompanyName(companyName);
            existingCompany.setCeo(ceo);
            existingCompany.setFounder(founder);
            existingCompany.setCo_founder(co_founder);
            existingCompany.setIndustryType(industryType);
            existingCompany.setTotalValuation(totalValuation);
            return companyService.updateCompany(id, existingCompany);
        } else {
            throw new RuntimeException("Company not found with id: " + id);
        }
    }


}

