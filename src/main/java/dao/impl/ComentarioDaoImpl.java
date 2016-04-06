package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ComentarioDao;
import dominio.Comentario;

public class ComentarioDaoImpl implements ComentarioDao {
	
	private EntityManager em;
	
	public ComentarioDaoImpl() {
		this.em = EM.getLocalEm();
	}

	@Override
	public void inserirAtualizar(Comentario x) {
		// TODO Auto-generated method stub
		if(x.getCodComentario() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Comentario x) {
		// TODO Auto-generated method stub
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Comentario buscar(int cod) {
		// TODO Auto-generated method stub
		return em.find(Comentario.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comentario> buscarTodos() {
		// TODO Auto-generated method stub
		String jpql = "SELECT x FROM Comentario x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
