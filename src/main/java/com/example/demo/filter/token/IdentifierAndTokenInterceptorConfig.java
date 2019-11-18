package com.example.demo.filter.token;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration  
public class IdentifierAndTokenInterceptorConfig extends WebMvcConfigurerAdapter  {  

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new IdentifierAndTokenInterceptor());
    }
} 
