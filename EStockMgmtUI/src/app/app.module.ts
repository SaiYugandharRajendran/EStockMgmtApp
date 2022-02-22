import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CompanyListComponent } from './company-list/company-list.component';
import { RegisterCompanyComponent } from './register-company/register-company.component';
import { FormsModule } from '@angular/forms';
import { UpdateCompanyComponent } from './update-company/update-company.component';
import { SearchCompanyComponent } from './search-company/search-company.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UpdatePostComponent } from './update-post/update-post.component';
import {MatButtonModule} from '@angular/material/button';
import {MatTableModule} from '@angular/material/table';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatInputModule} from '@angular/material/input';
import {MatIconModule} from '@angular/material/icon';

@NgModule({
  declarations: [
    AppComponent,
    CompanyListComponent,
    RegisterCompanyComponent,
    UpdateCompanyComponent,
    SearchCompanyComponent,
    UpdatePostComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    MatButtonModule,
    MatTableModule,
    MatToolbarModule,
    MatInputModule,
    MatIconModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
