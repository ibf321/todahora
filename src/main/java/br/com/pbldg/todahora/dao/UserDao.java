package br.com.pbldg.todahora.dao;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.pbldg.todahora.model.User;
import br.com.pbldg.todahora.model.UserProfile;

/**
 * 
 * @author pablo
 *
 */
@Named
@Dependent
public class UserDao {

	@PersistenceContext(unitName="todahora")
	private EntityManager em;

	@Transactional
	public void excluir(User usuario) {
		this.em.remove(this.em.contains(usuario) ? usuario : this.em.merge(usuario) );
	}

	public List<User> listaUsuarios() {
		TypedQuery<User> query = em.createQuery("select u from Usuario u", User.class);
		return query.getResultList();
	}
	
	@Transactional
	public void salvar(User usuario) {
		this.em.merge(usuario);
	}

	public void atualizar(User usuario) {
		this.em.merge(usuario);
	}

	public User findByEmail(String email) {
		String queryStr = "select u from Usuario u where u.email = :email";
		TypedQuery<User> query = this.em.createQuery(queryStr, User.class);
		query.setParameter("email", email);
		List<User> users = query.getResultList();
		return users.isEmpty() ? null : users.get(0);
	}
	
	public User findByEmailFake(String email) {
		User user = new User();
		user.setEmail("pablo");
		user.setPassword("$2a$10$5R/vxO9U5x.UW5WLZIDoFu0RnD9PfSY64j486PaULXq.oUeRbXuTm");
		user.setId(1L);
		user.setEnabled(true);
		
		List<User> users = new ArrayList<User>();
		users.add(user);
		
		UserProfile userProfile = new UserProfile();
		userProfile.setId(1L);
		userProfile.setType("ROLE_ADMIN");
		userProfile.setUsers(users);
		
		List<UserProfile> userProfiles = new ArrayList<UserProfile>();
		userProfiles.add(userProfile);
		
		user.setUserProfiles(userProfiles);
		
		return user; 
	}
}
