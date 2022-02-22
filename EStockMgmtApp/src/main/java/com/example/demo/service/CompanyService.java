package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.CompanyCodeAlreadyExistsException;
import com.example.demo.model.Company;

public interface CompanyService {
	
	public List<Company> getAllCompanyDetails();
	
	public Company addCompany(Company company) throws CompanyCodeAlreadyExistsException;
	
	public boolean deleteCompany(int companyCode);
	
	public boolean updateCompany(int companyCode, Company company);
	
	public Company getCompany(int companyCode);
	
	public boolean updateCompanyTurnover(int companyCode, Company company);


}
