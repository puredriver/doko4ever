package com.dogma.doko4ever;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dogma.doko4ever.service.CustomeUserDetailsService;

// @EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomeUserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll().and().formLogin().loginPage("/login")
				.defaultSuccessUrl("/home").failureUrl("/login?error=true").permitAll().and().logout()
				.logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll().and().csrf().disable();
	}

	//	@Override
	//	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
	//
	//	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
