package br.com.pbldg.apis2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/home.xhtml").hasRole("USER")
				.antMatchers("/views/**").hasRole("USER")
				.antMatchers("/resources/**").hasRole("USER")
				.antMatchers("/javax.faces.resource/**").permitAll()
				.and()
			.formLogin()
				.loginPage("/login.xhtml")
				.loginProcessingUrl("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.defaultSuccessUrl("/home.xhtml")
				.failureUrl("/login.xhtml?error")
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/logout")
				.invalidateHttpSession(true)
				.logoutSuccessUrl("/login.xhtml?logout");
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("pablo").password("123").roles("USER");
	}

}