package com.example.weatherApp.weather;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="city")
    private String city;
    @Column(name="country")
    private String country;

    @Column(name="temperature")
    private Float temperature;
    
    @Column(name="humidity")
    private Float humidity;
    
    @Column(name="wind_speed")
    private Float wind_speed;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Float getTemperature() {
		return temperature;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	public Float getHumidity() {
		return humidity;
	}

	public void setHumidity(Float humidity) {
		this.humidity = humidity;
	}

	public Float getWind_speed() {
		return wind_speed;
	}

	public void setWind_speed(Float wind_speed) {
		this.wind_speed = wind_speed;
	}

	public String getWeather_description() {
		return weather_description;
	}

	public void setWeather_description(String weather_description) {
		this.weather_description = weather_description;
	}

	public java.sql.Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(java.sql.Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Column(name="weather_description")
    private String weather_description;

    @Column(name = "timestamp", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private java.sql.Timestamp timestamp;

}
