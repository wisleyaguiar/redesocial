package servico;

import java.util.List;

import dao.DaoFactory;
import dao.PostagemDao;
import dao.Transaction;
import dominio.Postagem;

public class PostagemServico {
	
	private PostagemDao dao;
	
	public PostagemServico() {
		dao = DaoFactory.criarPostagemDao();
	}
	
	public void inserirAtualizar(Postagem x) {
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
	
	public void excluir(Postagem x) {
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
	
	public Postagem buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Postagem> buscarTodos(){
		return dao.buscarTodos();
	}
	
}
