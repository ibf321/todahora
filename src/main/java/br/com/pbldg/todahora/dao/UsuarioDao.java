package br.com.pbldg.todahora.dao;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.com.pbldg.todahora.model.Usuario;

/**
 * 
 * @author pablo
 *
 */
@Named
@Dependent
public class UsuarioDao {

	@PersistenceContext(unitName="todahora")
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

	public void atualizar(Usuario usuario) {
		this.em.merge(usuario);
	}
}
