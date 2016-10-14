package br.com.pbldg.todahora.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/secured/**", "/views/**").hasAnyRole("ADMIN", "USER")
				.and()
			.formLogin()
				.loginPage("/public/login.xhtml")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/secured/home.xhtml")
				.usernameParameter("username")
				.passwordParameter("password")
				.failureUrl("/public/login.xhtml?error")
				.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/public/login.xhtml");
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("pablo").password("123").roles("USER");
	}
	
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

}
