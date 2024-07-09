import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminComponent } from './components/admin/admin.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { AddadminComponent } from './components/admin/addadmin/addadmin.component';
import { LoginadminComponent } from './components/admin/loginadmin/loginadmin.component';
import { GetAllProvidersComponent } from './components/healthcare-provider/get-all-providers/get-all-providers.component';
import { LoginProviderComponent } from './components/healthcare-provider/login-provider/login-provider.component';
import { UpdateProviderComponent } from './components/healthcare-provider/update-provider/update-provider.component';
import { AddNewclaimComponent } from './components/insurance-claims/add-newclaim/add-newclaim.component';
import { GetAllInsuranceClaimsComponent } from './components/insurance-claims/get-all-insurance-claims/get-all-insurance-claims.component';
import { UpdateInsuranceClaimComponent } from './components/insurance-claims/update-insurance-claim/update-insurance-claim.component';
import { GetAllCompaniesComponent } from './components/insurance-company/get-all-companies/get-all-companies.component';
import { AddCompanyComponent } from './components/insurance-company/add-company/add-company.component';
import { UpdateCompanyComponent } from './components/insurance-company/update-company/update-company.component';
import { LoginCompanyComponent } from './components/insurance-company/login-company/login-company.component';
import { AddInsurancePlanComponent } from './components/insurance-plans/add-insurance-plan/add-insurance-plan.component';
import { GetAllInsurancePlansComponent } from './components/insurance-plans/get-all-insurance-plans/get-all-insurance-plans.component';
import { GetPlanbyCompanynameComponent } from './components/insurance-plans/get-planby-companyname/get-planby-companyname.component';
import { AddInvoiceComponent } from './components/invoice-details/add-invoice/add-invoice.component';
import { GetInvoiceComponent } from './components/invoice-details/get-invoice/get-invoice.component';
import { GetAllInvoicesComponent } from './components/invoice-details/get-all-invoices/get-all-invoices.component';
import { GetInvoiceByPatientnameComponent } from './components/invoice-details/get-invoice-by-patientname/get-invoice-by-patientname.component';
import { AddPatientComponent } from './components/patients/add-patient/add-patient.component';
import { UpdatePatientComponent } from './components/patients/update-patient/update-patient.component';
import { GetAllPatientsComponent } from './components/patients/get-all-patients/get-all-patients.component';
import { GetByPatientnameComponent } from './components/patients/get-by-patientname/get-by-patientname.component';
import { LoginPatientComponent } from './components/patients/login-patient/login-patient.component';
import { AddProviderComponent } from './components/healthcare-provider/add-provider/add-provider.component';
import { PatientPanelComponent } from './components/patients/patient-panel/patient-panel.component';
import { CompanyPanelComponent } from './components/insurance-company/company-panel/company-panel.component';
import { AdminPanelComponent } from './components/admin/admin-panel/admin-panel.component';
import { ProviderPanelComponent } from './components/healthcare-provider/provider-panel/provider-panel.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    HomepageComponent,
    AddadminComponent,
    LoginadminComponent,
    GetAllProvidersComponent,
    LoginProviderComponent,
    UpdateProviderComponent,
    AddNewclaimComponent,
    GetAllInsuranceClaimsComponent,
    UpdateInsuranceClaimComponent,
    GetAllCompaniesComponent,
    AddCompanyComponent,
    UpdateCompanyComponent,
    LoginCompanyComponent,
    AddInsurancePlanComponent,
    GetAllInsurancePlansComponent,
    GetPlanbyCompanynameComponent,
    AddInvoiceComponent,
    GetInvoiceComponent,
    GetAllInvoicesComponent,
    GetInvoiceByPatientnameComponent,
    AddPatientComponent,
    UpdatePatientComponent,
    GetAllPatientsComponent,
    GetByPatientnameComponent,
    LoginPatientComponent,
    AddProviderComponent,
    PatientPanelComponent,
    CompanyPanelComponent,
    AdminPanelComponent,
    ProviderPanelComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
