package br.com.pbldg.todahora.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import br.com.pbldg.todahora.model.User;


public class CustomUserDetails extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;
	private User user;

	public CustomUserDetails(User user, List<? extends GrantedAuthority> authorityList) {
		super(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, authorityList);
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
