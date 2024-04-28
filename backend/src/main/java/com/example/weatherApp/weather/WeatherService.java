package com.example.weatherApp.weather;

import java.util.List;
import java.util.Optional;

public interface WeatherService {
	
	  List<Weather> getAll() ;
	    
	     Optional<Weather> findById(Long id); 
	    
	     Weather create(Weather weather) ;
	   
	     void deleteById(Long id);
	     
	     Weather  findByCity(String city);
	     
	   

}
