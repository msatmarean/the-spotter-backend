package com.spotter.thespotter.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().and().authorizeRequests().antMatchers("/**").authenticated().and().oauth2ResourceServer().jwt();
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

}
