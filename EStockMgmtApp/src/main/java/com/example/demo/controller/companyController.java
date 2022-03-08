package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.exception.CompanyCodeAlreadyExistsException;
import com.example.demo.model.Company;
import com.example.demo.service.CompanyService;

@RestController
@RequestMapping("/api/v1.0/market")
@CrossOrigin("*")
public class companyController {
	
	@Autowired
	CompanyService companyService;
	
	@GetMapping("/company/getall")
	public ResponseEntity<?> getall(){
		List<Company> companylist = companyService.getAllCompanyDetails();
		if(companylist!=null)
			return new ResponseEntity<List<Company>>(companylist,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Company List is empty!",HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/company/info/{code}")
	public ResponseEntity<?> getCompany(@PathVariable("code") int code){
		Company company = companyService.getCompany(code);
		if(company!=null) 
			return new ResponseEntity<Company>(company,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Company does not exist!",HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(value="/company/register",consumes="application/json; charset=utf-8")
	public ResponseEntity<?> addCompany(@RequestBody Company company) throws CompanyCodeAlreadyExistsException{
		if(companyService.addCompany(company)!=null)
			return new ResponseEntity<Company>(company,HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("Data is not inserted!",HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/company/delete/{code}")
	public ResponseEntity<?> delete(@PathVariable("code") int code){
		Company company = companyService.getCompany(code);
		if(companyService.deleteCompany(code))
			return new ResponseEntity<Company>(company,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Cannot delete due to internal error",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value="/stock/add/{code}",consumes="application/json; charset=utf-8")
	public ResponseEntity<?> updatePost(@PathVariable("code") int code, @RequestBody Company company){
		if(companyService.updateCompany(code, company))
			return new ResponseEntity<>(company,HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("Cannot update!",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping(value="/stock/put/{code}",consumes="application/json; charset=utf-8")
	public ResponseEntity<?> updatePut(@PathVariable("code") int code, @RequestBody Company company){
		if(companyService.updateCompany(code, company))
			return new ResponseEntity<>(company,HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("Cannot update!",HttpStatus.INTERNAL_SERVER_ERROR);
	}	

}
