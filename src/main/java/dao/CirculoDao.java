package dao;

import java.util.List;

import dominio.Circulo;

public interface CirculoDao {
	
	public void inserirAtualizar(Circulo x);
	public void excluir(Circulo x);
	public Circulo buscar(int cod);
	public List<Circulo> buscarTodos();
}
