import { Component, OnInit } from '@angular/core';
import { WeatherService } from '../service/weather.service';
import { Weather } from '../Weather';

@Component({
  selector: 'app-weather-show',
  templateUrl: './weather-show.component.html',
  styleUrl: './weather-show.component.css'
})
export class WeatherShowComponent implements OnInit  {
  city: string = '';
  weatherData: Weather | null = null;
  errorMessage: string = '';

  constructor(private weatherService: WeatherService) {}

  ngOnInit(): void {}

  getWeatherByCity() {
    this.weatherService.getWeatherByCity(this.city).subscribe(
      (data) => {
        this.weatherData = data;
        this.errorMessage = '';
      },
      (error) => {
        this.weatherData = null;
        this.errorMessage = 'City not found or error fetching weather data.';
      }
    );
  }

  getBackgroundImage(): string {
    // Return a different background image based on the weather description
    if (!this.weatherData) {
      return 'assets/default.jpg'; // Default background
    }

    const weatherDesc = this.weatherData.weather_description.toLowerCase();

    if (weatherDesc.includes('sunny')) {
      return 'assets/sunny.webp';
    } else if (weatherDesc.includes('cloudy')) {
      return 'assets/clody.webp';
    } else if (weatherDesc.includes('rainy')) {
      return 'assets/rainy.jpeg';
    } else if (weatherDesc.includes('snowy')) {
      return 'assets/snowy.jpeg';
    } else {
      return 'assets/default.jpg'; // Default or fallback background
    }
  }
}
