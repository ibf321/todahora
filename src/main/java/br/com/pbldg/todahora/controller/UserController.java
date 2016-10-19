package br.com.pbldg.todahora.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.pbldg.todahora.dao.UserDao;
import br.com.pbldg.todahora.model.User;


@Named
@RequestScoped
public class UserController implements Serializable {

	private static final long serialVersionUID = 5202799275364383072L;

	private User user;

	private List<User> listaUsuarios;

	@Inject
	private UserDao userDao;

	@PostConstruct
	public void init() {
		this.user = new User();
	}

	public List<User> getUsers() {
		if (this.listaUsuarios == null || this.listaUsuarios.isEmpty()) {
			this.listaUsuarios = this.userDao.listaUsuarios();
		}
		return this.listaUsuarios;
	}


	public String excluir() {
		this.userDao.excluir(this.user);
		this.listaUsuarios = userDao.listaUsuarios();
		this.user = new User();
		return "index?faces-redirect=true";
	}

	public String irPaginaAtualizar(User user) {
		this.user = user;
		return "usuario/atualizar";
	}

	public String irPaginaSalvar() {
		return "usuario/cadastrar?faces-redirect=true";
	}

	@Transactional
	public String atualizar() {
		this.userDao.atualizar(this.user);
		this.user = new User();
		return "../index";
	}

	public String salvar() {
		this.userDao.salvar(this.user);
		this.listaUsuarios = userDao.listaUsuarios();
		this.user = new User();
		return "../index";
	}

	public String voltar() {
		return "/index?faces-redirect=true";
	}

	public List<User> getlistaUsuarios() {
		return listaUsuarios;
	}

	public void setlistaUsuarios(List<User> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
