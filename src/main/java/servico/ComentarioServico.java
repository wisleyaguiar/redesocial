package servico;

import java.util.List;

import dao.ComentarioDao;
import dao.DaoFactory;
import dao.Transaction;
import dominio.Comentario;

public class ComentarioServico {
	
	private ComentarioDao dao;
	
	public ComentarioServico() {
		dao = DaoFactory.criarComentarioDao();
	}
	
	public void inserirAtualizar(Comentario x) {
		try {
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if(Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void excluir(Comentario x) {
		try {
			Transaction.begin();
			dao.excluir(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if(Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public Comentario buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Comentario> buscarTodos(){
		return dao.buscarTodos();
	}
	
}
