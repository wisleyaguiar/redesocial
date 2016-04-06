package dao;

import java.util.List;

import dominio.Comentario;

public interface ComentarioDao {
	
	public void inserirAtualizar(Comentario x);
	public void excluir(Comentario x);
	public Comentario buscar(int cod);
	public List<Comentario> buscarTodos();
}
