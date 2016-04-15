package servico;

import java.util.List;

import dao.CirculoDao;
import dao.DaoFactory;
import dao.Transaction;
import dominio.Circulo;

public class CirculoServico {
	
	private CirculoDao dao;
	
	public CirculoServico() {
		dao = DaoFactory.criarCirculoDao();
	}
	
	public void inserirAtualizar(Circulo x) {
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
	
	public void excluir(Circulo x) {
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
	
	public Circulo buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Circulo> buscarTodos(){
		return dao.buscarTodos();
	}
	
}
