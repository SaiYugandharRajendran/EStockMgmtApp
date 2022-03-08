package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CompanyTest {

	@Test
	void testId() {
		Company company = new Company();
		int expected = 100;
		company.setCompanyCode(100);
		int actual = company.getCompanyCode();
		assertEquals(expected, actual);
	}
	@Test
	void testName() {
		Company company = new Company();
		String expected = "Company";
		company.setCompanyName("Company");;
		String actual = company.getCompanyName();
		assertEquals(expected, actual);
	}
	@Test
	void testCEO() {
		Company company = new Company();
		String expected = "Company";
		company.setCompanyCEO("Company");;
		String actual = company.getCompanyCEO();
		assertEquals(expected, actual);
	}
	@Test
	void testWebsite() {
		Company company = new Company();
		String expected = "Company";
		company.setCompanyWebsite("Company");;
		String actual = company.getCompanyWebsite();
		assertEquals(expected, actual);
	}
	@Test
	void testStockExchange() {
		Company company = new Company();
		String expected = "Company";
		company.setStockExchange("Company");;
		String actual = company.getStockExchange();
		assertEquals(expected, actual);
	}
	@Test
	void testTurnOver() {
		Company company = new Company();
		double expected = 5000;
		company.setCompanyTurnover(5000);;
		double actual = company.getCompanyTurnover();
		assertEquals(expected, actual);
	}
	@Test
	void testStockPrice() {
		Company company = new Company();
		double expected = 5000;
		company.setStockPrice(5000);;
		double actual = company.getStockPrice();
		assertEquals(expected, actual);
	}

}
