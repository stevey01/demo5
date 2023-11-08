package com.example.demo2.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication()
		.withUser("hi")
		.password("hi")
		.roles("Owner")
		.and()
		.withUser("hello")
		.password("hello")
		.roles("Manager")
		.and()
		.withUser("welcome")
		.password("welcome")
		.roles("Receptionist");
	}
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
		
	}
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
		.antMatchers("/owner").hasRole("Owner")
	    
	    .antMatchers("/manager").hasAnyRole("Manager","Owner")
	    .antMatchers("reception").hasRole("Receptionist")
	    .antMatchers("/").permitAll()
	    .and().formLogin();
	}
}
