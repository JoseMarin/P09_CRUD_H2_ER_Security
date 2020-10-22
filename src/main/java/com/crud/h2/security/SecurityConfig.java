package com.crud.h2.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  
	@Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http.csrf().disable().authorizeRequests()
	    .antMatchers(HttpMethod.POST,"/api/clientes").hasRole("admin")
	    .antMatchers(HttpMethod.GET,"/api/videos").hasRole("admin")
	    .and()
	     // some more method calls
	    .formLogin();
  }

 
	  
}