import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HealthcareProvider } from 'src/app/model/HealthcareProvider';
import { JwtProviderService } from './jwt-provider.service';
import { JwtAdminService } from '../AdminService/jwt-admin.service';

@Injectable({
  providedIn: 'root'
})
export class HealthcareProviderService {

  providerName!:string;
  providerURL: string = 'http://localhost:8085/api/healthcareprovider';

  constructor(private http: HttpClient,private jwtProvider:JwtProviderService,private jwtAdmin:JwtAdminService) { }


  registerHealthcareProvider(provider:HealthcareProvider):Observable<HealthcareProvider>
  {
    // console.log(provider);
    return this.http.post<HealthcareProvider>(this.providerURL+"/add",provider);
  }

  getAllProviders(): Observable<HealthcareProvider[]> {
    const token = this.jwtAdmin.getToken();

    console.log(token);
    if (token) {
      const tokenString = 'Bearer ' + token;
      const headers = new HttpHeaders().set('Authorization', tokenString);

     
      console.log(headers);
      return this.http.get<HealthcareProvider[]>(this.providerURL + '/getall', { headers});
      }
      else{
        return new Observable<HealthcareProvider[]>;
      }
  }

  deleteProviderById(providerId: number): Observable<string> {
    const token = this.jwtAdmin.getToken();

    console.log(token);
    if (token) {
      const tokenString = 'Bearer ' + token;
      const headers = new HttpHeaders().set('Authorization', tokenString);
      return this.http.delete<string>(this.providerURL + `/deletebyid/${providerId}`,{headers})
    }
    else{
      return new Observable<string>();
    }
  }

  updateProvider(provider:HealthcareProvider):Observable<HealthcareProvider>
  {
    const token = this.jwtProvider.getToken();

    console.log(token);
    if (token) {
      const tokenString = 'Bearer ' + token;
      const headers = new HttpHeaders().set('Authorization', tokenString);

     
      console.log(headers);
      return this.http.put<HealthcareProvider>(this.providerURL + '/update',provider, { headers});
      }
      else{
        return new Observable<HealthcareProvider>;
      }
  }

  setProviderName(name:string)
  {
    this.providerName=name;
  }

  getProviderName()
  {
    return this.providerName;
  }
}
