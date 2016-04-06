package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.AlbumDao;
import dominio.Album;

public class AlbumDaoImpl implements AlbumDao {
	
	private EntityManager em;
	
	public AlbumDaoImpl() {
		this.em = EM.getLocalEm();
	}

	@Override
	public void inserirAtualizar(Album x) {
		// TODO Auto-generated method stub
		if(x.getCodAlbum() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Album x) {
		// TODO Auto-generated method stub
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Album buscar(int cod) {
		// TODO Auto-generated method stub
		return em.find(Album.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Album> buscarTodos() {
		// TODO Auto-generated method stub
		String jpql = "SELECT x FROM Album x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
