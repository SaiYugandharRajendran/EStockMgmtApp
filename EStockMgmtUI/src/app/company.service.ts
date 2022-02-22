import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Company } from './company';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {
  private apiGet:string ='http://localhost:8082/api/v1.0/market/company/getall';
  private apiDel:string =`http://localhost:8082/api/v1.0/market/company/delete`;
  private apiRegisterPost:string =`http://localhost:8082/api/v1.0/market/company/register`;
  private apiGetCompany:string = `http://localhost:8082/api/v1.0/market/company/info`;
  private apiPut:string =`http://localhost:8082/api/v1.0/market/stock/put`;
  private apiPostUpdate:string=`http://localhost:8082/api/v1.0/market/stock/add`;


  constructor(private http : HttpClient) { }

  getall():Observable<Array<Company>>{
    return this.http.get<Array<Company>>(this.apiGet);
  }

  getCompany(companyCode:number):Observable<Company>{
    return this.http.get<Company>(`${this.apiGetCompany}/${companyCode}`);
  }

  delete(companyCode:number):Observable<Company>{
    return this.http.delete<Company>(`${this.apiDel}/${companyCode}`);
  }

  addCompany(companymod:Company):Observable<Company>{
    console.log(companymod);
    return this.http.post<Company>(this.apiRegisterPost,companymod);
  }

  updatePut(companyCode:number,companymod:Company):Observable<Company>{
    console.log(companymod);
    return this.http.put<Company>(`${this.apiPut}/${companyCode}`,companymod);
  }

  updatePost(companyCode:number,companymod:Company):Observable<Company>{
    console.log(companymod);
    return this.http.post<Company>(`${this.apiPostUpdate}/${companyCode}`,companymod);
  }

}
