package com.example.weatherApp.weather;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    
	@Autowired
	private WeatherRepository weatherRepository;
	
	@Override
	public List<Weather> getAll() {
		return weatherRepository.findAll();
	}

	@Override
	public Optional<Weather> findById(Long id) {
		
		return weatherRepository.findById(id);
	}

	@Override
	public Weather create(Weather weather) {
		 return weatherRepository.save(weather);
	}

	@Override
	public void deleteById(Long id) {
		 weatherRepository.deleteById(id);
		
	}

	@Override
	public Weather findByCity(String city) {
		
		  return weatherRepository.findByCity(city);
	}

}
