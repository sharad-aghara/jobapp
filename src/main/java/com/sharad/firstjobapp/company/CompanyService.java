package com.sharad.firstjobapp.company;

import java.util.List;

public interface CompanyService {

    List<Company> getAll();

    Company updateByID(Long id, Company updateCompany);

    void createCompany(Company company);

    boolean deleteCompanyById(Long id);

    Company getCompanyById(Long id);

}
