package com.lulu02.GO1_login;

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
public class Go1LoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(Go1LoginApplication.class, args);
	}
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("one","/GO1/**").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/GO1/**")
                .authenticated().and().formLogin().and().build();
    }

}
