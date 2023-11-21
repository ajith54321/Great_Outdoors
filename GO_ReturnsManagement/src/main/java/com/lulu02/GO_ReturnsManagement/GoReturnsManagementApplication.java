package com.lulu02.GO_ReturnsManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
@EnableFeignClients
@SpringBootApplication
@EnableWebSecurity
@EnableMethodSecurity
public class GoReturnsManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoReturnsManagementApplication.class, args);
	}
	@Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        return http.csrf().disable()
	                .authorizeHttpRequests()
                    .requestMatchers("one","/GO5/**").permitAll()
	                .and()
	                .authorizeHttpRequests().requestMatchers("/GO5/**")
	                .authenticated().and().formLogin().and().build();
	    }
}
