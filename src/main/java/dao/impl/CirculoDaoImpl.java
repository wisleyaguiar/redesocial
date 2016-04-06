package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.CirculoDao;
import dominio.Circulo;

public class CirculoDaoImpl implements CirculoDao {
	
	private EntityManager em;
	
	public CirculoDaoImpl() {
		this.em = EM.getLocalEm();
	}

	@Override
	public void inserirAtualizar(Circulo x) {
		// TODO Auto-generated method stub
		if(x.getCodCirculo() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Circulo x) {
		// TODO Auto-generated method stub
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Circulo buscar(int cod) {
		// TODO Auto-generated method stub
		return em.find(Circulo.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Circulo> buscarTodos() {
		// TODO Auto-generated method stub
		String jpql = "SELECT x FROM Circulo x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
