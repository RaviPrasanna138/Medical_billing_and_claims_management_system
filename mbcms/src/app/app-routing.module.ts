import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './components/homepage/homepage.component';
import { LoginadminComponent } from './components/admin/loginadmin/loginadmin.component';
import { LoginProviderComponent } from './components/healthcare-provider/login-provider/login-provider.component';
import { LoginCompanyComponent } from './components/insurance-company/login-company/login-company.component';
import { LoginPatientComponent } from './components/patients/login-patient/login-patient.component';
import { AddProviderComponent } from './components/healthcare-provider/add-provider/add-provider.component';
import { AddCompanyComponent } from './components/insurance-company/add-company/add-company.component';
import { AddadminComponent } from './components/admin/addadmin/addadmin.component';
import { AddPatientComponent } from './components/patients/add-patient/add-patient.component';
import { UpdatePatientComponent } from './components/patients/update-patient/update-patient.component';
import { GetAllCompaniesComponent } from './components/insurance-company/get-all-companies/get-all-companies.component';
import { GetAllPatientsComponent } from './components/patients/get-all-patients/get-all-patients.component';
import { GetAllInsuranceClaimsComponent } from './components/insurance-claims/get-all-insurance-claims/get-all-insurance-claims.component';
import { GetAllProvidersComponent } from './components/healthcare-provider/get-all-providers/get-all-providers.component';
import { GetAllInsurancePlansComponent } from './components/insurance-plans/get-all-insurance-plans/get-all-insurance-plans.component';
import { GetAllInvoicesComponent } from './components/invoice-details/get-all-invoices/get-all-invoices.component';
import { UpdateProviderComponent } from './components/healthcare-provider/update-provider/update-provider.component';
import { GetInvoiceComponent } from './components/invoice-details/get-invoice/get-invoice.component';
import { GetByPatientnameComponent } from './components/patients/get-by-patientname/get-by-patientname.component';
import { GetPlanbyCompanynameComponent } from './components/insurance-plans/get-planby-companyname/get-planby-companyname.component';
import { UpdateInsuranceClaimComponent } from './components/insurance-claims/update-insurance-claim/update-insurance-claim.component';
import { UpdateCompanyComponent } from './components/insurance-company/update-company/update-company.component';
import { AddNewclaimComponent } from './components/insurance-claims/add-newclaim/add-newclaim.component';
import { GetInvoiceByPatientnameComponent } from './components/invoice-details/get-invoice-by-patientname/get-invoice-by-patientname.component';
import { AdminPanelComponent } from './components/admin/admin-panel/admin-panel.component';
import { ProviderPanelComponent } from './components/healthcare-provider/provider-panel/provider-panel.component';
import { PatientPanelComponent } from './components/patients/patient-panel/patient-panel.component';
import { CompanyPanelComponent } from './components/insurance-company/company-panel/company-panel.component';

const routes: Routes = [
  { path: '', component: HomepageComponent },
  { path: 'login/admin', component: LoginadminComponent },
  { path: 'login/provider', component: LoginProviderComponent },
  { path: 'login/patient', component: LoginPatientComponent },
  { path: 'login/company', component: LoginCompanyComponent },
  { path: 'registerpatient', component: AddPatientComponent },
  { path: 'registercompany', component: AddCompanyComponent },
  { path: 'registerprovider', component: AddProviderComponent },

  { path: 'updatepatients/:id', component: UpdatePatientComponent },


  { path: 'admin/dashboard', component: AdminPanelComponent, children: [ {path:'addadmin',component:AddadminComponent},{ path: 'getallcompanies', component: GetAllCompaniesComponent }, { path: 'getallpatients', component: GetAllPatientsComponent }, { path: 'getallclaims', component: GetAllInsuranceClaimsComponent }, { path: 'getallproviders', component: GetAllProvidersComponent }, { path: 'getallplans', component: GetAllInsurancePlansComponent }, { path: 'getallinvoices', component: GetAllInvoicesComponent }] },
  { path: 'provider/dashboard', component: ProviderPanelComponent, children: [{ path: 'update/provider', component: UpdateProviderComponent }, { path: 'generateinvoice/:patientId', component: GetInvoiceComponent }, { path: 'get/patientname', component: GetByPatientnameComponent }, { path: 'getallpatients', component: GetAllPatientsComponent }] },
  { path: 'company/dashboard', component: CompanyPanelComponent, children: [{path:'getplan/companyname' ,component:GetPlanbyCompanynameComponent},{ path: 'update/:claimId', component: UpdateInsuranceClaimComponent }, { path: 'updatecompany', component: UpdateCompanyComponent}, { path: 'add/plan/:companyName', component: AddNewclaimComponent },] },
  { path: 'patient/dashboard', component: PatientPanelComponent, children: [ { path: 'getinvoice/:patientName', component: GetInvoiceByPatientnameComponent }, { path: 'update/patient', component: UpdatePatientComponent }, { path: 'add/newclaim', component: AddNewclaimComponent }] },

  { path: 'generateinvoice/:patientId', component: GetInvoiceByPatientnameComponent },
  { path: 'addclaim/:patientName/:planId', component: AddNewclaimComponent },
  { path: 'getallinvocies/:invoiceId', component: GetAllInvoicesComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
