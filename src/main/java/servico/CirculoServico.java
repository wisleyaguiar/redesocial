package servico;

import java.util.List;

import dao.CirculoDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Circulo;

public class CirculoServico {
	
	private CirculoDao dao;
	
	public CirculoServico() {
		dao = DaoFactory.criarCirculoDao();
	}
	
	public void inserirAtualizar(Circulo x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Circulo x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Circulo buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Circulo> buscarTodos(){
		return dao.buscarTodos();
	}
	
}
