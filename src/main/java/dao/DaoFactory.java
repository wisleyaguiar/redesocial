package dao;

import dao.impl.AlbumDaoImpl;
import dao.impl.CirculoDaoImpl;
import dao.impl.ComentarioDaoImpl;
import dao.impl.FotoDaoImpl;
import dao.impl.PostagemDaoImpl;
import dao.impl.UsuarioDaoImpl;

public class DaoFactory {
	
	public static AlbumDao criarAlbumDao() {
		return new AlbumDaoImpl();
	}
	
	public static CirculoDao criarCirculoDao() {
		return new CirculoDaoImpl();
	}
	
	public static ComentarioDao criarComentarioDao() {
		return new ComentarioDaoImpl();
	}
	
	public static FotoDao criarFotoDao() {
		return new FotoDaoImpl();
	}
	
	public static PostagemDao criarPostagemDao() {
		return new PostagemDaoImpl();
	}
	
	public static UsuarioDao criarUsuarioDao() {
		return new UsuarioDaoImpl();
	}
	
}
