package com.dogma.doko4ever;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("password")).roles("USER");

		//		.and().withUser("manager").password("password").credentialsExpired(true).accountExpired(true)
		//		.accountLocked(true).authorities("WRITE_PRIVILEGES", "READ_PRIVILEGES").roles("MANAGER");
	}

	//	@Autowired
	//	private CustomeUserDetailsService userDetailsService;

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	//		http.authorizeRequests().antMatchers("/login").permitAll().and().formLogin().loginPage("/login")
	//				.defaultSuccessUrl("/home").failureUrl("/login?error=true").permitAll().and().logout()
	//				.logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll().and().csrf().disable();
	// }

	//	@Override
	//	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
	//
	//	}

	//	@Bean
	//	public DaoAuthenticationProvider authenticationProvider() {
	//		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	//		authenticationProvider.setUserDetailsService(userDetailsService);
	//		authenticationProvider.setPasswordEncoder(passwordEncoder());
	//		return authenticationProvider;
	//	}
	//
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
