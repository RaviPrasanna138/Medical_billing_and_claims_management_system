import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HealthcareProvider } from '../model/HealthcareProvider';

@Injectable({
  providedIn: 'root'
})
export class HealthcareProviderService {

  private baseUrl = 'http://localhost:8080/api/providers'; // Update with your actual API URL

  constructor(private http: HttpClient) { }

  addProvider(provider: HealthcareProvider): Observable<HealthcareProvider> {
    return this.http.post<HealthcareProvider>(`${this.baseUrl}/add`, provider);
  }

  updateProvider(provider: HealthcareProvider): Observable<HealthcareProvider> {
    return this.http.put<HealthcareProvider>(`${this.baseUrl}/update`, provider);
  }

  getAllProviders(): Observable<HealthcareProvider[]> {
    return this.http.get<HealthcareProvider[]>(`${this.baseUrl}/all`);
  }

  getProviderById(providerId: number): Observable<HealthcareProvider> {
    return this.http.get<HealthcareProvider>(`${this.baseUrl}/${providerId}`);
  }

  deleteProviderById(providerId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete/${providerId}`);
  }
}
