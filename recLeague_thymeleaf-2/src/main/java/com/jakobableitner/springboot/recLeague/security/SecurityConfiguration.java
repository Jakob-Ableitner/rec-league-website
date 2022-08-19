package com.jakobableitner.springboot.recLeague.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration {

	@Autowired
	  private PasswordEncoder passwordEncoder;
	  
	  @Bean
	  protected PasswordEncoder passwordEncoder () {
	    return new BCryptPasswordEncoder();
	  }
	
	@Bean
	protected UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
	    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	    manager.createUser(User.withUsername("admin")
	    		.password(bCryptPasswordEncoder.encode("pass"))
	      .roles("ADMIN")
	      .build());
	    return manager;
	}
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
	      .csrf().disable()
	      .authorizeRequests()
	        .antMatchers("/admin/**").hasAnyRole("ADMIN").and()
	      .formLogin()
	        .loginPage("/login")
	        .defaultSuccessUrl("/admin/home")
	        .permitAll();

	    return http.build();
	}
	

	   protected void configure(HttpSecurity http) throws Exception {
	        http
	            .logout(logout -> logout
	            	.logoutUrl("/login")
	                .logoutSuccessUrl("/login")                     
	                .invalidateHttpSession(true)
	                .deleteCookies("JSESSIONID")
	            );
	    }
	}