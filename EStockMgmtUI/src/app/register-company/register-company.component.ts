import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Company } from '../company';
import { CompanyService } from '../company.service';

@Component({
  selector: 'app-register-company',
  templateUrl: './register-company.component.html',
  styleUrls: ['./register-company.component.css']
})
export class RegisterCompanyComponent implements OnInit {

  companymod:Company = new Company();
  companies:Array<Company> = [];
  data:{} |any;

  constructor(private http:HttpClient, private companyService:CompanyService) { }

  ngOnInit(): void {
  }

  addCompany(){
    this.companyService.addCompany(this.companymod).subscribe(data=>
      {
        this.data = JSON.stringify(data);
        this.companies.push(this.data);
      },
      error=>
      {
        console.log(error);
      })
  }

}
