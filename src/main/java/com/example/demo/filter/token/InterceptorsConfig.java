package com.example.demo.filter.token;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Class responsible for registering interceptors in the project.
 * 
 * @author cesar.fagundes
 *
 */
@SuppressWarnings("deprecation")
@Configuration  
public class InterceptorsConfig extends WebMvcConfigurerAdapter  {  

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new IdentifierAndTokenInterceptor());
    }
} 
