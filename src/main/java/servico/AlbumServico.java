package servico;

import java.util.List;

import dao.AlbumDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Album;

public class AlbumServico {
	
	private AlbumDao dao;
	
	public AlbumServico() {
		dao = DaoFactory.criarAlbumDao();
	}
	
	public void inserirAtualizar(Album x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Album x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Album buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Album> buscarTodos(){
		return dao.buscarTodos();
	}
	
}
