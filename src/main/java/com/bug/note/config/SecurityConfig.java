package com.bug.note.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
	
	private final AuthenticationFailureHandler customFailureHandler;
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/", "/board/**").authenticated()
			.anyRequest().permitAll()
		.and()
			.formLogin()
			.loginPage("/auth/login")
			.loginProcessingUrl("/auth/login")
			.failureHandler(customFailureHandler) // 로그인 실패 핸들러
			.defaultSuccessUrl("/")
		.and()
			.logout()
			.invalidateHttpSession(true).deleteCookies("JSESSIONID");
	
	return http.build();
	}

}
