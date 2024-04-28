// src/app/weather.entity.ts
export interface Weather {
    id: number; // Unique identifier
    city: string; // City name
    country: string; // Country name
    temperature: number; // Temperature in degrees Celsius
    humidity: number; // Humidity percentage
    wind_speed: number; // Wind speed in km/h
    weather_description: string; // Weather description
    timestamp: Date; // Timestamp of the weather data
  }
  