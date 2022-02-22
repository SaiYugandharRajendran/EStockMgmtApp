import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Company } from '../company';
import { CompanyService } from '../company.service';

@Component({
  selector: 'app-company-list',
  templateUrl: './company-list.component.html',
  styleUrls: ['./company-list.component.css']
})
export class CompanyListComponent implements OnInit {
  companies:Array<Company> = [];
  data:{} |any;
  companyCode:number |any;

  constructor(private companyService: CompanyService, private router:Router) { }

  ngOnInit(): void {
    this.getCompanies();
  }

  private getCompanies(){
    this.companyService.getall().subscribe(data=>
      {
        console.log(Object.values(data));
        this.companies=Object.values(data);
      },
      error=>{
        console.log(error);
      })
  }

  delete(companyCode:number){
    this.companyService.delete(companyCode).subscribe(data=>
      {
        console.log("Record is deleted!",data);
        let cIndex=this.companies.findIndex(c=>c.companyCode === companyCode);
        console.log(cIndex);
        this.companies.splice(cIndex,1);
        this.getCompanies();
      },
      error=>
      {
        console.log(error);
      })
  }

  searchCompany(companyCode:number){
    this.router.navigate(['search-company',companyCode]);
  }

  updateCompany(companyCode:number, companymod:Company){
    this.router.navigate(['update-company',companyCode]);
  }

  updatePost(companyCode:number,companymod:Company){
    this.router.navigate(['update-post',companyCode]);
  }

}
