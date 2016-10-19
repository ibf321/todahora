package br.com.pbldg.todahora.security;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.pbldg.todahora.dao.UserDao;
import br.com.pbldg.todahora.model.User;
import br.com.pbldg.todahora.model.UserProfile;

@Named
@RequestScoped
public class CustomUserDetailsService implements UserDetailsService {

	@Inject
	private UserDao userDao;

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = userDao.findByEmailFake(email);

		if (user == null) {
			throw new UsernameNotFoundException("Username not found");
		}
		
		List<SimpleGrantedAuthority> authorityList = new ArrayList<SimpleGrantedAuthority>();

		List<UserProfile> profiles = user.getUserProfiles();

		for (UserProfile profile : profiles) {
			authorityList.add(new SimpleGrantedAuthority(profile.getType()));
		}
		
		return new CustomUserDetails(user, authorityList);

	}
	
}