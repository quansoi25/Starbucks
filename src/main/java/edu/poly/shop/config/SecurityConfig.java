package edu.poly.shop.config;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.poly.shop.domain.Account;
import edu.poly.shop.service.AccountService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	AccountService accountService;
	@Autowired
	BCryptPasswordEncoder pe;
	@Autowired
	DataSource datasource;
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username->{
			try {
				Account user=accountService.findById(username);
				String password =pe.encode(user.getPassword());
				String[] roles=user.getAuthorities().stream()
						.map(er->er.getRole().getId())
						.collect(Collectors.toList()).toArray(new String[0]);
				return User.withUsername(username).password(password).roles(roles).build();
			}catch(NoSuchElementException e) {
				throw new UsernameNotFoundException(username+"not found!");
			}
		});
//		auth.jdbcAuthentication().dataSource(datasource)
//				.usersByUsernameQuery("SELECT USERNAME,PASSWORD FROM ACCOUNTS WHERE USERNAME=?")
//				.authoritiesByUsernameQuery("SELECT USERNAME,ROLES FROM ACCOUNTS WHERE USERNAME=?");
	};
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable();
			http.authorizeRequests()
				.antMatchers("/order/**").authenticated()
				.antMatchers("/admin/**").hasAnyRole("ADMIN","STAFF")
				.anyRequest().permitAll();
			http.formLogin()
				.loginPage("/security/login/form")
				.loginProcessingUrl("/security/login")
				.defaultSuccessUrl("/security/login/form/success",false)
				.failureUrl("/security/login/error");
			http.rememberMe()
				.tokenValiditySeconds(86400);
			http.exceptionHandling()
				.accessDeniedPage("/security/unauthoried");
			http.logout()
				.logoutUrl("/security/logoff")
				.logoutSuccessUrl("/security/logoff/success");
			
			http.oauth2Login()
			.loginPage("/security/login/form")
			.defaultSuccessUrl("/security/oauth2/login/success",true)
			.failureUrl("/security/login/error")
			.authorizationEndpoint()
				.baseUri("/oauth2/authoriztion");
		}
		
		
		
	}

