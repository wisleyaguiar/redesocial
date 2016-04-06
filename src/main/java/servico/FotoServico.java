package servico;

import java.util.List;

import dao.FotoDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Foto;

public class FotoServico {
	
	private FotoDao dao;
	
	public FotoServico() {
		dao = DaoFactory.criarFotoDao();
	}
	
	public void inserirAtualizar(Foto x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Foto x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Foto buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Foto> buscarTodos(){
		return dao.buscarTodos();
	}
	
}
