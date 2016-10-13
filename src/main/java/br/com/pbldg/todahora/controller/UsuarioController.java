package br.com.pbldg.todahora.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.pbldg.todahora.dao.UsuarioDao;
import br.com.pbldg.todahora.model.Usuario;



@Named
@RequestScoped
public class UsuarioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5202799275364383072L;

	private Usuario usuario;

	private List<Usuario> listaUsuarios;

	@Inject
	private UsuarioDao usuarioDao;

	@PostConstruct
	public void init() {
		this.usuario = new Usuario();
	}

	public List<Usuario> getUsuarios() {
		if (this.listaUsuarios == null || this.listaUsuarios.isEmpty()) {
			this.listaUsuarios = usuarioDao.listaUsuarios();
		}
		return this.listaUsuarios;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String excluir() {
		this.usuarioDao.excluir(usuario);
		this.listaUsuarios = usuarioDao.listaUsuarios();
		this.usuario = new Usuario();
		return "index?faces-redirect=true";
	}

	public String irPaginaAtualizar(Usuario usuario) {
		this.usuario = usuario;
		return "usuario/atualizar";
	}

	public String irPaginaSalvar() {
		return "usuario/cadastrar?faces-redirect=true";
	}

	@Transactional
	public String atualizar() {
		this.usuarioDao.atualizar(this.usuario);
		this.usuario = new Usuario();
		return "../index";
	}

	public String salvar() {
		this.usuarioDao.salvar(this.usuario);
		this.listaUsuarios = usuarioDao.listaUsuarios();
		this.usuario = new Usuario();
		return "../index";
	}

	public String voltar() {
		return "/index?faces-redirect=true";
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
}
