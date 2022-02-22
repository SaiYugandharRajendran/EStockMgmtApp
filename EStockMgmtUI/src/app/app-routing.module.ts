import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CompanyListComponent } from './company-list/company-list.component';
import { RegisterCompanyComponent } from './register-company/register-company.component';
import { SearchCompanyComponent } from './search-company/search-company.component';
import { UpdateCompanyComponent } from './update-company/update-company.component';
import { UpdatePostComponent } from './update-post/update-post.component';

const routes: Routes = [
  {path:'companies',component:CompanyListComponent},
  {path:'register-company',component:RegisterCompanyComponent},
  {path:'update-company/:companyCode',component:UpdateCompanyComponent},
  {path:'search-company/:companyCode',component:SearchCompanyComponent},
  {path:'update-post/:companyCode',component:UpdatePostComponent},
  {path:'',redirectTo:'companies',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
