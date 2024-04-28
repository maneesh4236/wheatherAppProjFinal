package com.example.weatherApp.weather;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
	
	
	
	 @Autowired
	    private WeatherServiceImpl weatherServiceImpl;

	    @GetMapping
	    public ResponseEntity<List<Weather>> getAllWeather() {
	        List<Weather> weatherList = weatherServiceImpl.getAll();
	        return new ResponseEntity<>(weatherList,HttpStatus.OK);
	    }
	    
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<Weather> getWeatherById(@PathVariable("id") Long id) {
	    
	        Optional<Weather> weather = weatherServiceImpl.findById(id);
	        return weather.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }
	    
	    
	    @PostMapping
	    public ResponseEntity<Weather> createWeather(@RequestBody Weather weather) {
	        Weather createdWeather = weatherServiceImpl.create(weather);
	        return ResponseEntity.ok(createdWeather);
	    }
	    
	    
	    @GetMapping("/city/{city}")
	    public ResponseEntity<Weather> getWeatherByCity(@PathVariable("city") String city) {
	        Optional<Weather> weather = Optional.ofNullable(weatherServiceImpl.findByCity(city));
	        return weather.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Weather> updateWeather(@PathVariable("id") Long id, @RequestBody Weather weatherDetails) {
	        Optional<Weather> existingWeather = weatherServiceImpl.findById(id);

	        if (existingWeather.isPresent()) {
	            Weather weather = existingWeather.get();
	            weather.setCity(weatherDetails.getCity());
	            weather.setCountry(weatherDetails.getCountry());
	            weather.setTemperature(weatherDetails.getTemperature());
	            weather.setHumidity(weatherDetails.getHumidity());
	            weather.setWind_speed(weatherDetails.getWind_speed());
	            weather.setWeather_description(weatherDetails.getWeather_description());
	            weatherServiceImpl.create(weather);

	            return ResponseEntity.ok(weather);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteWeather(@PathVariable("id") Long id) {
	        if (weatherServiceImpl.findById(id).isPresent()) {
	        	weatherServiceImpl.deleteById(id);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
