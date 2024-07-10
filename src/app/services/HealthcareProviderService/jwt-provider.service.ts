import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class JwtProviderService {
  private providerURL: string = 'http://localhost:8085/api/healthcareprovider/';
  private tokenKey: string = 'jwtToken';

  constructor(private http: HttpClient) {}

  login(userName: string, password: string): Observable<string> {
    const requestBody = { userName, password };
    return this.http.post<string>(this.providerURL + 'authenticate', requestBody,{responseType: 'text' as 'json'});
  }
  // logout(): void {
  //   localStorage.removeItem(this.tokenKey);
  // }

  setToken(token: string): void {
    localStorage.setItem(this.tokenKey, token);
  }

  getToken(): string | null {
    return localStorage.getItem(this.tokenKey);
  }

  clearToken(): void {
    localStorage.removeItem(this.tokenKey);
  }
}
