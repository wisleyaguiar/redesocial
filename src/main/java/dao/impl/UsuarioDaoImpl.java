package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.UsuarioDao;
import dominio.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {
	
	private EntityManager em;
	
	public UsuarioDaoImpl() {
		this.em = EM.getLocalEm();
	}

	@Override
	public void inserirAtualizar(Usuario x) {
		// TODO Auto-generated method stub
		if(x.getCodUsuario() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Usuario x) {
		// TODO Auto-generated method stub
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Usuario buscar(int cod) {
		// TODO Auto-generated method stub
		return em.find(Usuario.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		String jpql = "SELECT x FROM Usuario x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarTodosOrdenadoPorNome() {
		// TODO Auto-generated method stub
		String jpql = "SELECT x FROM Usuario x ORDER BY x.nome";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
