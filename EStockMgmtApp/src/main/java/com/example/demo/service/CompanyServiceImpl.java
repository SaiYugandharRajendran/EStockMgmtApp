package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.CompanyCodeAlreadyExistsException;
import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyRepository companyRepo;

	@Override
	public List<Company> getAllCompanyDetails() {
		List<Company> companylist = companyRepo.findAll();
		if(companylist!=null && companylist.size()>0)
			return companylist;
		else
			return null;
	}

	@Override
	public Company addCompany(Company company) throws CompanyCodeAlreadyExistsException{
		
		Optional<Company> optional = companyRepo.findById(company.getCompanyCode());
		
		if(optional.isPresent()) {
			throw new CompanyCodeAlreadyExistsException();
		}
		else 
			return companyRepo.saveAndFlush(company);
	}

	@Override
	public boolean deleteCompany(int companyCode) {
		companyRepo.deleteById(companyCode);
		return true;
	}

	@Override
	public boolean updateCompany(int companyCode, Company company) {
		Company company1 = companyRepo.getById(companyCode);
		if(company1!=null) {
			company1.setCompanyTurnover(company.getCompanyTurnover());
			company1.setCompanyName(company.getCompanyName());
			company1.setCompanyCEO(company.getCompanyCEO());
			company1.setStockExchange(company.getStockExchange());
			company1.setStockPrice(company.getStockPrice());
			company.setCompanyWebsite(company.getCompanyWebsite());
			companyRepo.saveAndFlush(company1);
			return true;
		}
		else 
			return false;
	}

	@Override
	public Company getCompany(int companyCode) {
		Optional<Company> optional = companyRepo.findById(companyCode);
		if(optional.isPresent()) {
			return optional.get();
		}
		else return null;
	}

	@Override
	public boolean updateCompanyTurnover(int companyCode, Company company) {
		Company company1 = companyRepo.getById(companyCode);
		if(company1!=null) {
			company1.setCompanyTurnover(company.getCompanyTurnover());
			company1.setCompanyName(company.getCompanyName());
			company1.setCompanyCEO(company.getCompanyCEO());
			company1.setStockExchange(company.getStockExchange());
			company1.setStockPrice(company.getStockPrice());
			company.setCompanyWebsite(company.getCompanyWebsite());
			companyRepo.saveAndFlush(company1);
			return true;
		}
		else 
			return false;
	}

}
