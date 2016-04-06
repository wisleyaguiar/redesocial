package dao;

import java.util.List;

import dominio.Postagem;

public interface PostagemDao {
	
	public void inserirAtualizar(Postagem x);
	public void excluir(Postagem x);
	public Postagem buscar(int cod);
	public List<Postagem> buscarTodos();
}
