import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {
  private apiUrl = 'http://localhost:8080/api/weather';

  constructor(private http: HttpClient) {}

  // Get all weather data
  getAllWeather(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}`);
  }

  // Get weather data by city
  getWeatherByCity(city: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/city/${city}`);
  }

  // Create new weather data
  createWeather(weather: any): Observable<any> {
    return this.http.post(`${this.apiUrl}`, weather);
  }

  // Update weather data
  updateWeather(id: number, weather: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}`, weather);
  }

  // Delete weather data
  deleteWeather(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
