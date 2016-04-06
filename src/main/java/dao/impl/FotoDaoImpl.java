package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.FotoDao;
import dominio.Foto;

public class FotoDaoImpl implements FotoDao {
	
	private EntityManager em;
	
	public FotoDaoImpl() {
		this.em = EM.getLocalEm();
	}

	@Override
	public void inserirAtualizar(Foto x) {
		// TODO Auto-generated method stub
		if(x.getCodFoto() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Foto x) {
		// TODO Auto-generated method stub
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Foto buscar(int cod) {
		// TODO Auto-generated method stub
		return em.find(Foto.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Foto> buscarTodos() {
		// TODO Auto-generated method stub
		String jpql = "SELECT x FROM Foto x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
