package br.com.pbldg.apis2.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.com.pbldg.apis2.model.Usuario;

/**
 * 
 * @author pablo
 *
 */
@RequestScoped
public class UsuarioDao implements Serializable {

	private static final long serialVersionUID = 5233215231835772290L;
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void excluir(Usuario usuario) {
		this.em.remove(this.em.contains(usuario) ? usuario : this.em.merge(usuario) );
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listaUsuarios() {
		return this.em.createQuery("select u from Usuario u").getResultList();
	}
	
	@Transactional
	public void salvar(Usuario usuario) {
		this.em.merge(usuario);
	}

	@Transactional
	public void atualizar(Usuario usuario) {
		this.em.merge(usuario);
	}
}
