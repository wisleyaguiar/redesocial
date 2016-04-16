package servico;

import dao.DaoFactory;
import dao.UsuarioDao;
import dominio.Usuario;

public class Login {

	public static Usuario usuarioLogado() {
		UsuarioDao dao = DaoFactory.criarUsuarioDao();
		return dao.buscar(1);
	}
}
