package br.com.pbldg.apis2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.pbldg.apis2.dao.UsuarioDao;
import br.com.pbldg.apis2.model.Usuario;

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
		if (this.listaUsuarios == null || this.listaUsuarios.isEmpty()){
			this.listaUsuarios = usuarioDao.listaUsuarios();
		}
		return this.listaUsuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void excluir(Usuario usuario){
		this.usuarioDao.excluir(usuario);
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
