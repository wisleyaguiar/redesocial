package servico;

import java.util.List;

import dao.ComentarioDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Comentario;

public class ComentarioServico {
	
	private ComentarioDao dao;
	
	public ComentarioServico() {
		dao = DaoFactory.criarComentarioDao();
	}
	
	public void inserirAtualizar(Comentario x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Comentario x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Comentario buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Comentario> buscarTodos(){
		return dao.buscarTodos();
	}
	
}
