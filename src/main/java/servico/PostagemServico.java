package servico;

import java.util.List;

import dao.PostagemDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Postagem;

public class PostagemServico {
	
	private PostagemDao dao;
	
	public PostagemServico() {
		dao = DaoFactory.criarPostagemDao();
	}
	
	public void inserirAtualizar(Postagem x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Postagem x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Postagem buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Postagem> buscarTodos(){
		return dao.buscarTodos();
	}
	
}
