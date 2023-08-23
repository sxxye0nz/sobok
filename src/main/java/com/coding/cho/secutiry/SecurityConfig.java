package com.coding.cho.secutiry;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
	
	//url
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authorize -> authorize
					.antMatchers("/webjars/**", "/js/**", "/css/**", "/images/**","/video/**").permitAll()
					.antMatchers("/","/signup","/common/**","/menu/**").permitAll()
					.anyRequest().authenticated()
			)
			.formLogin(form->form
					.loginPage("/signin")//get /signin
					//.loginProcessingUrl("/signin")//설정하지않으면 loginPageUrl이 적용
					.usernameParameter("email")//UserDetails가 처리
					.passwordParameter("pass")
					.defaultSuccessUrl("/", true)//테스트 상황에서
					.permitAll()				
			)
			.logout(logout->logout
					.logoutUrl("/signout")
							.logoutSuccessUrl("/")
			);
			
			
		return http.build();
	}
	


}
