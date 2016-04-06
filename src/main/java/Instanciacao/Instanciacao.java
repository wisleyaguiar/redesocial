package Instanciacao;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Album;
import dominio.Circulo;
import dominio.Comentario;
import dominio.Foto;
import dominio.Postagem;
import dominio.Usuario;
import servico.AlbumServico;
import servico.CirculoServico;
import servico.ComentarioServico;
import servico.FotoServico;
import servico.PostagemServico;
import servico.UsuarioServico;

@WebServlet("/Instanciacao")
public class Instanciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Usuario user1 = new Usuario(null, "Wisley Aguiar", "wisley@tobe.ppg.br", "(34) 3236-0333", "Wisley123", sdf.parse("01/03/1985"), new BigDecimal("2000.00"));
			Usuario user2 = new Usuario(null, "Jose Francisco","documxd@hotmail.com", "(34) 3245-3422", "Jose123", sdf.parse("24/03/1986"), new BigDecimal("1500.00"));
			Usuario user3 = new Usuario(null, "Lucas Francisco", "lucas@cintreq.com.br","(34) 9287-9845", "lucas123", sdf.parse("05/06/1987"), new BigDecimal("1500.00"));
			Usuario user4 = new Usuario(null, "Miguel Francisco", "miguel@gmail.com", "(34) 2345-0456", "miguel123", sdf.parse("05/10/1949"), new BigDecimal("1500.00"));
			Usuario user5 = new Usuario(null, "Edilma Anita Aguiar", "edilma@gmail.com", "(34) 2156-0486","edilma123", sdf.parse("31/05/1956"), new BigDecimal("820.00"));
			
			Postagem post1 = new Postagem(null, sdf.parse("18/03/2016"), "Um ano muito bom eu acredito!", user1);
			Postagem post2 = new Postagem(null, sdf.parse("19/03/2016"), "A festa estava muito boa ontem!", user1);
			Postagem post3 = new Postagem(null, sdf.parse("18/03/2016"), "Partiu festa!", user2);
			Postagem post4 = new Postagem(null, sdf.parse("20/03/2016"), "Partiu viagem!", user2);
			Postagem post5 = new Postagem(null, sdf.parse("20/03/2016"), "Almoço estava bom!", user3);
			Postagem post6 = new Postagem(null, sdf.parse("22/03/2016"), "A carne estava crua!", user3);
			Postagem post7 = new Postagem(null, sdf.parse("21/03/2016"), "Partiu churrasco!", user4);
			Postagem post8 = new Postagem(null, sdf.parse("22/03/2016"), "Terminei o namoro!", user4);
			Postagem post9 = new Postagem(null, sdf.parse("18/03/2016"), "Estou feliz!", user5);
			Postagem post10 = new Postagem(null, sdf.parse("20/03/2016"), "Agora estou triste!", user5);
			
			Comentario comment1 = new Comentario(null, sdf.parse("18/03/2016"), "Coment 1!!", post1, user2);
			Comentario comment2 = new Comentario(null, sdf.parse("19/03/2016"), "Coment 2!!", post1, user1);
			Comentario comment3 = new Comentario(null, sdf.parse("20/03/2016"), "Coment 3!!", post2, user3);
			Comentario comment4 = new Comentario(null, sdf.parse("20/03/2016"), "Coment 4!!", post2, user2);
			Comentario comment5 = new Comentario(null, sdf.parse("22/03/2016"), "Coment 5!!", post3, user4);
			Comentario comment6 = new Comentario(null, sdf.parse("23/03/2016"), "Coment 6!!", post3, user5);
			Comentario comment7 = new Comentario(null, sdf.parse("22/03/2016"), "Coment 7!!", post4, user3);
			Comentario comment8 = new Comentario(null, sdf.parse("24/03/2016"), "Coment 8!!", post4, user2);
			Comentario comment9 = new Comentario(null, sdf.parse("25/03/2016"), "Coment 9!!", post5, user1);
			Comentario comment10 = new Comentario(null, sdf.parse("26/03/2016"), "Coment 10!!", post5, user4);
			Comentario comment11 = new Comentario(null, sdf.parse("22/03/2016"), "Coment 11!!", post6, user3);
			Comentario comment12 = new Comentario(null, sdf.parse("22/03/2016"), "Coment 12!!", post6, user1);
			Comentario comment13 = new Comentario(null, sdf.parse("23/03/2016"), "Coment 13!!", post7, user5);
			Comentario comment14 = new Comentario(null, sdf.parse("24/03/2016"), "Coment 14!!", post7, user3);
			Comentario comment15 = new Comentario(null, sdf.parse("25/03/2016"), "Coment 15!!", post8, user2);
			Comentario comment16 = new Comentario(null, sdf.parse("26/03/2016"), "Coment 16!!", post8, user5);
			Comentario comment17 = new Comentario(null, sdf.parse("27/03/2016"), "Coment 17!!", post9, user1);
			Comentario comment18 = new Comentario(null, sdf.parse("28/03/2016"), "Coment 18!!", post9, user3);
			Comentario comment19 = new Comentario(null, sdf.parse("23/03/2016"), "Coment 19!!", post10, user4);
			Comentario comment20 = new Comentario(null, sdf.parse("24/03/2016"), "Coment 20!!", post10, user5);
			
			Album alb1 = new Album(null, "Ferias em Santos", user1);
			Album alb2 = new Album(null, "Ferias em Fortaleza", user1);
			Album alb3 = new Album(null, "Ferias em Salvador", user2);
			Album alb4 = new Album(null, "Ferias em Natal", user2);
			Album alb5 = new Album(null, "Ferias em Brasolia", user3);
			Album alb6 = new Album(null, "Ferias em Sao Paulo", user3);
			Album alb7 = new Album(null, "Ferias em Gramado", user4);
			Album alb8 = new Album(null, "Ferias em Portugual", user4);
			Album alb9 = new Album(null, "Ferias em Manaus", user5);
			Album alb10 = new Album(null, "Ferias em Porto Alegre", user5);
			
			Foto foto1 = new Foto(null, "foto1", "muito legal", 24, alb1);
			Foto foto2 = new Foto(null, "foto2", "muito legal", 25, alb1);
			Foto foto3 = new Foto(null, "foto3", "muito legal", 32, alb2);
			Foto foto4 = new Foto(null, "foto4", "muito legal", 64, alb2);
			Foto foto5 = new Foto(null, "foto5", "muito legal", 156, alb3);
			Foto foto6 = new Foto(null, "foto6", "muito legal", 65, alb3);
			Foto foto7 = new Foto(null, "foto7", "muito legal", 37, alb4);
			Foto foto8 = new Foto(null, "foto8", "muito legal", 75, alb4);
			Foto foto9 = new Foto(null, "foto9", "muito legal", 34, alb5);
			Foto foto10 = new Foto(null, "foto10", "muito legal", 57, alb5);
			Foto foto11 = new Foto(null, "foto11", "muito legal", 32, alb6);
			Foto foto12 = new Foto(null, "foto12", "muito legal", 78, alb6);
			Foto foto13 = new Foto(null, "foto13", "muito legal", 42, alb7);
			Foto foto14 = new Foto(null, "foto14", "muito legal", 89, alb7);
			Foto foto15 = new Foto(null, "foto15", "muito legal", 345, alb8);
			Foto foto16 = new Foto(null, "foto16", "muito legal", 652, alb8);
			Foto foto17 = new Foto(null, "foto17", "muito legal", 345, alb9);
			Foto foto18 = new Foto(null, "foto18", "muito legal", 322, alb9);
			Foto foto19 = new Foto(null, "foto19", "muito legal", 356, alb10);
			Foto foto20 = new Foto(null, "foto20", "muito legal", 489, alb10);
			
			Circulo amigo1 = new Circulo(null, sdf.parse("18/03/2016"), user1, user2);
			Circulo amigo2 = new Circulo(null, sdf.parse("18/03/2016"), user1, user3);
			Circulo amigo3 = new Circulo(null, sdf.parse("18/03/2016"), user1, user4);
			
			Circulo amigo4 = new Circulo(null, sdf.parse("18/03/2016"), user2, user1);
			Circulo amigo5 = new Circulo(null, sdf.parse("18/03/2016"), user2, user3);
			Circulo amigo6 = new Circulo(null, sdf.parse("18/03/2016"), user2, user4);
			
			Circulo amigo7 = new Circulo(null, sdf.parse("18/03/2016"), user3, user2);
			Circulo amigo8 = new Circulo(null, sdf.parse("18/03/2016"), user3, user5);
			Circulo amigo9 = new Circulo(null, sdf.parse("18/03/2016"), user3, user4);
			
			Circulo amigo10 = new Circulo(null, sdf.parse("18/03/2016"), user4, user2);
			Circulo amigo11 = new Circulo(null, sdf.parse("18/03/2016"), user4, user3);
			Circulo amigo12 = new Circulo(null, sdf.parse("18/03/2016"), user4, user1);
			
			Circulo amigo13 = new Circulo(null, sdf.parse("18/03/2016"), user5, user1);
			Circulo amigo14 = new Circulo(null, sdf.parse("18/03/2016"), user5, user2);
			Circulo amigo15 = new Circulo(null, sdf.parse("18/03/2016"), user5, user3);
			
			// Usando a camada de serviços
			
			AlbumServico as = new AlbumServico();
			CirculoServico cs = new CirculoServico();
			ComentarioServico cos = new ComentarioServico();
			FotoServico fs = new FotoServico();
			PostagemServico ps = new PostagemServico();
			UsuarioServico us = new UsuarioServico();
			
			us.inserirAtualizar(user1);
			us.inserirAtualizar(user2);
			us.inserirAtualizar(user3);
			us.inserirAtualizar(user4);
			us.inserirAtualizar(user5);
			
			ps.inserirAtualizar(post1);
			ps.inserirAtualizar(post2);
			ps.inserirAtualizar(post3);
			ps.inserirAtualizar(post4);
			ps.inserirAtualizar(post5);
			ps.inserirAtualizar(post6);
			ps.inserirAtualizar(post7);
			ps.inserirAtualizar(post8);
			ps.inserirAtualizar(post9);
			ps.inserirAtualizar(post10);
			
			cos.inserirAtualizar(comment1);
			cos.inserirAtualizar(comment2);
			cos.inserirAtualizar(comment3);
			cos.inserirAtualizar(comment4);
			cos.inserirAtualizar(comment5);
			cos.inserirAtualizar(comment6);
			cos.inserirAtualizar(comment7);
			cos.inserirAtualizar(comment8);
			cos.inserirAtualizar(comment9);
			cos.inserirAtualizar(comment10);
			cos.inserirAtualizar(comment11);
			cos.inserirAtualizar(comment12);
			cos.inserirAtualizar(comment13);
			cos.inserirAtualizar(comment14);
			cos.inserirAtualizar(comment15);
			cos.inserirAtualizar(comment16);
			cos.inserirAtualizar(comment17);
			cos.inserirAtualizar(comment18);
			cos.inserirAtualizar(comment19);
			cos.inserirAtualizar(comment20);
			
			as.inserirAtualizar(alb1);
			as.inserirAtualizar(alb2);
			as.inserirAtualizar(alb3);
			as.inserirAtualizar(alb4);
			as.inserirAtualizar(alb5);
			as.inserirAtualizar(alb6);
			as.inserirAtualizar(alb7);
			as.inserirAtualizar(alb8);
			as.inserirAtualizar(alb9);
			as.inserirAtualizar(alb10);
			
			fs.inserirAtualizar(foto1);
			fs.inserirAtualizar(foto2);
			fs.inserirAtualizar(foto3);
			fs.inserirAtualizar(foto4);
			fs.inserirAtualizar(foto5);
			fs.inserirAtualizar(foto6);
			fs.inserirAtualizar(foto7);
			fs.inserirAtualizar(foto8);
			fs.inserirAtualizar(foto9);
			fs.inserirAtualizar(foto10);
			fs.inserirAtualizar(foto11);
			fs.inserirAtualizar(foto12);
			fs.inserirAtualizar(foto13);
			fs.inserirAtualizar(foto14);
			fs.inserirAtualizar(foto15);
			fs.inserirAtualizar(foto16);
			fs.inserirAtualizar(foto17);
			fs.inserirAtualizar(foto18);
			fs.inserirAtualizar(foto19);
			fs.inserirAtualizar(foto20);
			
			cs.inserirAtualizar(amigo1);
			cs.inserirAtualizar(amigo2);
			cs.inserirAtualizar(amigo3);
			cs.inserirAtualizar(amigo4);
			cs.inserirAtualizar(amigo5);
			cs.inserirAtualizar(amigo6);
			cs.inserirAtualizar(amigo7);
			cs.inserirAtualizar(amigo8);
			cs.inserirAtualizar(amigo9);
			cs.inserirAtualizar(amigo10);
			cs.inserirAtualizar(amigo11);
			cs.inserirAtualizar(amigo12);
			cs.inserirAtualizar(amigo13);
			cs.inserirAtualizar(amigo14);
			cs.inserirAtualizar(amigo15);
			
			response.getWriter().append("Pronto");
		}
		catch(ParseException e) {
			response.getWriter().append("Erro ao instanciar Data!");
		}
	}

}
