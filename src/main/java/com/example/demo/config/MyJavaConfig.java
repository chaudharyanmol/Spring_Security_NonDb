package com.example.demo.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfAuthenticationStrategy;
import org.springframework.util.AntPathMatcher;

import com.example.demo.OneApplication;
import jakarta.servlet.FilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class MyJavaConfig {

    private final OneApplication oneApplication;
    MyJavaConfig(OneApplication oneApplication) {
        this.oneApplication = oneApplication;
    }
	  @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		  
		  
	        http.
	        csrf(csrf -> csrf.disable())
	        .authorizeRequests()
	        .requestMatchers("/home").permitAll()
	        .requestMatchers("/findAll").hasRole("ADMIN")
	        .anyRequest().
	        authenticated().
	        and().
	        httpBasic();

	        return http.build();
	    }
	    @Bean
	    public UserDetailsService userDetailsService() {
	        UserDetails user1 = User.withUsername("anmol") 
	                .password("{noop}abcd") 
	                .roles("USER") 
	                .build();

	        UserDetails admin = User.withUsername("shrishti") 
	                .password("{noop}1234") 
	                .roles("ADMIN") // ✅ Assigning role
	                .build();

	        return new InMemoryUserDetailsManager(user1, admin);
	    }
	  



	   

}
