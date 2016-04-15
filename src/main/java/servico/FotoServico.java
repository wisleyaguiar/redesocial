package servico;

import java.util.List;

import dao.DaoFactory;
import dao.FotoDao;
import dao.Transaction;
import dominio.Foto;

public class FotoServico {
	
	private FotoDao dao;
	
	public FotoServico() {
		dao = DaoFactory.criarFotoDao();
	}
	
	public void inserirAtualizar(Foto x) {
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
	
	public void excluir(Foto x) {
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
	
	public Foto buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Foto> buscarTodos(){
		return dao.buscarTodos();
	}
	
}
