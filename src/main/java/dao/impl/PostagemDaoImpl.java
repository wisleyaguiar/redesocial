package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.PostagemDao;
import dominio.Postagem;

public class PostagemDaoImpl implements PostagemDao {
	
	private EntityManager em;
	
	public PostagemDaoImpl() {
		this.em = EM.getLocalEm();
	}

	@Override
	public void inserirAtualizar(Postagem x) {
		// TODO Auto-generated method stub
		if(x.getCodPostagem() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Postagem x) {
		// TODO Auto-generated method stub
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Postagem buscar(int cod) {
		// TODO Auto-generated method stub
		return em.find(Postagem.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Postagem> buscarTodos() {
		// TODO Auto-generated method stub
		String jpql = "SELECT x FROM Postagem x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
