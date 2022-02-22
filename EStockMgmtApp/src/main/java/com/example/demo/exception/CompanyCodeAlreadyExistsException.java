package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT,reason="Company code already exists!")
public class CompanyCodeAlreadyExistsException extends Exception{

}
