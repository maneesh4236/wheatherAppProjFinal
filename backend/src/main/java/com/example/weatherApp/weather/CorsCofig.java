package com.example.weatherApp.weather;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;




@Configuration
public class CorsCofig {







    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            	 System.out.println("CORS configuration invoked");
                registry.addMapping("/**")
                     
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods(
                                HttpMethod.GET.name(),
                                HttpMethod.POST.name(),
                                HttpMethod.PUT.name(),
                                HttpMethod.DELETE.name()
                        ).allowedHeaders(HttpHeaders.CONTENT_TYPE,
                        		HttpHeaders.AUTHORIZATION);
                System.out.println("CORS configuration final");
                
            }
        };
    }

}
