package Instanciacao;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

@WebServlet("/Instanciacao")
public class Instanciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Usuario user1 = new Usuario(null, "Wisley Aguiar", "wisley@tobe.ppg.br", "(34) 3236-0333", "Wisley123", sdf.parse("01/03/1985"), new BigDecimal("2000.00"));
			Usuario user2 = new Usuario(null, "José Francisco","documxd@hotmail.com", "(34) 3245-3422", "Jose123", sdf.parse("24/03/1986"), new BigDecimal("1500.00"));
			Usuario user3 = new Usuario(null, "Lucas Francisco", "lucas@cintreq.com.br","(34) 9287-9845", "lucas123", sdf.parse("05/06/1987"), new BigDecimal("1500.00"));
			Usuario user4 = new Usuario(null, "Miguel Francisco", "miguel@gmail.com", "(34) 2345-0456", "miguel123", sdf.parse("05/10/1949"), new BigDecimal("1500.00"));
			Usuario user5 = new Usuario(null, "Edilma Anita Aguiar", "edilma@gmail.com", "(34) 2156-0486","edilma123", sdf.parse("31/05/1956"), new BigDecimal("820.00"));
			
			Postagem post1 = new Postagem(null, sdf.parse("18/03/2016"), "Um ano muito bom eu acredito!", user1);
			Postagem post2 = new Postagem(null, sdf.parse("18/03/2016"), "A festa estava muito boa ontem!", user1);
			Postagem post3 = new Postagem(null, sdf.parse("18/03/2016"), "Um ano muito bom eu acredito!", user2);
			Postagem post4 = new Postagem(null, sdf.parse("18/03/2016"), "A festa estava muito boa ontem!", user2);
			Postagem post5 = new Postagem(null, sdf.parse("18/03/2016"), "Um ano muito bom eu acredito!", user3);
			Postagem post6 = new Postagem(null, sdf.parse("18/03/2016"), "A festa estava muito boa ontem!", user3);
			Postagem post7 = new Postagem(null, sdf.parse("18/03/2016"), "Um ano muito bom eu acredito!", user4);
			Postagem post8 = new Postagem(null, sdf.parse("18/03/2016"), "A festa estava muito boa ontem!", user4);
			Postagem post9 = new Postagem(null, sdf.parse("18/03/2016"), "Um ano muito bom eu acredito!", user5);
			Postagem post10 = new Postagem(null, sdf.parse("18/03/2016"), "A festa estava muito boa ontem!", user5);
			
			Comentario comment1 = new Comentario(null, sdf.parse("18/03/2016"), "Que coisa heim vei!!", post1, user2);
			Comentario comment2 = new Comentario(null, sdf.parse("18/03/2016"), "Que coisa heim vei!!", post1, user1);
			Comentario comment3 = new Comentario(null, sdf.parse("18/03/2016"), "Que coisa heim vei!!", post2, user3);
			Comentario comment4 = new Comentario(null, sdf.parse("18/03/2016"), "Que coisa heim vei!!", post2, user2);
			Comentario comment5 = new Comentario(null, sdf.parse("18/03/2016"), "Que coisa heim vei!!", post3, user4);
			Comentario comment6 = new Comentario(null, sdf.parse("18/03/2016"), "Que coisa heim vei!!", post3, user5);
			Comentario comment7 = new Comentario(null, sdf.parse("18/03/2016"), "Que coisa heim vei!!", post4, user3);
			Comentario comment8 = new Comentario(null, sdf.parse("18/03/2016"), "Que coisa heim vei!!", post4, user2);
			Comentario comment9 = new Comentario(null, sdf.parse("18/03/2016"), "Que coisa heim vei!!", post5, user1);
			Comentario comment10 = new Comentario(null, sdf.parse("18/03/2016"), "Que coisa heim vei!!", post5, user4);
			Comentario comment11 = new Comentario(null, sdf.parse("18/03/2016"), "Que coisa heim vei!!", post6, user3);
			Comentario comment12 = new Comentario(null, sdf.parse("18/03/2016"), "Que coisa heim vei!!", post6, user1);
			Comentario comment13 = new Comentario(null, sdf.parse("18/03/2016"), "Que coisa heim vei!!", post7, user5);
			Comentario comment14 = new Comentario(null, sdf.parse("18/03/2016"), "Que coisa heim vei!!", post7, user3);
			Comentario comment15 = new Comentario(null, sdf.parse("18/03/2016"), "Que coisa heim vei!!", post8, user2);
			Comentario comment16 = new Comentario(null, sdf.parse("18/03/2016"), "Que coisa heim vei!!", post8, user5);
			Comentario comment17 = new Comentario(null, sdf.parse("18/03/2016"), "Que coisa heim vei!!", post9, user1);
			Comentario comment18 = new Comentario(null, sdf.parse("18/03/2016"), "Que coisa heim vei!!", post9, user3);
			Comentario comment19 = new Comentario(null, sdf.parse("18/03/2016"), "Que coisa heim vei!!", post10, user4);
			Comentario comment20 = new Comentario(null, sdf.parse("18/03/2016"), "Que coisa heim vei!!", post10, user5);
			
			Album alb1 = new Album(null, "Ferias em Santos", user1);
			Album alb2 = new Album(null, "Ferias em Fortaleza", user1);
			Album alb3 = new Album(null, "Ferias em Salvador", user2);
			Album alb4 = new Album(null, "Ferias em Natal", user2);
			Album alb5 = new Album(null, "Ferias em Brasília", user3);
			Album alb6 = new Album(null, "Ferias em São Paulo", user3);
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
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("meujpa");
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			
			em.persist(user1);
			em.persist(user2);
			em.persist(user3);
			em.persist(user4);
			em.persist(user5);
			
			em.persist(post1);
			em.persist(post2);
			em.persist(post3);
			em.persist(post4);
			em.persist(post5);
			em.persist(post6);
			em.persist(post7);
			em.persist(post8);
			em.persist(post9);
			em.persist(post10);
			
			em.persist(comment1);
			em.persist(comment2);
			em.persist(comment3);
			em.persist(comment4);
			em.persist(comment5);
			em.persist(comment6);
			em.persist(comment7);
			em.persist(comment8);
			em.persist(comment9);
			em.persist(comment10);
			em.persist(comment11);
			em.persist(comment12);
			em.persist(comment13);
			em.persist(comment14);
			em.persist(comment15);
			em.persist(comment16);
			em.persist(comment17);
			em.persist(comment18);
			em.persist(comment19);
			em.persist(comment20);
			
			em.persist(alb1);
			em.persist(alb2);
			em.persist(alb3);
			em.persist(alb4);
			em.persist(alb5);
			em.persist(alb6);
			em.persist(alb7);
			em.persist(alb8);
			em.persist(alb9);
			em.persist(alb10);
			
			em.persist(foto1);
			em.persist(foto2);
			em.persist(foto3);
			em.persist(foto4);
			em.persist(foto5);
			em.persist(foto6);
			em.persist(foto7);
			em.persist(foto8);
			em.persist(foto9);
			em.persist(foto10);
			em.persist(foto11);
			em.persist(foto12);
			em.persist(foto13);
			em.persist(foto14);
			em.persist(foto15);
			em.persist(foto16);
			em.persist(foto17);
			em.persist(foto18);
			em.persist(foto19);
			em.persist(foto20);
			
			em.persist(amigo1);
			em.persist(amigo2);
			em.persist(amigo3);
			em.persist(amigo4);
			em.persist(amigo5);
			em.persist(amigo6);
			em.persist(amigo7);
			em.persist(amigo8);
			em.persist(amigo9);
			em.persist(amigo10);
			em.persist(amigo11);
			em.persist(amigo12);
			em.persist(amigo13);
			em.persist(amigo14);
			em.persist(amigo15);
			
			em.getTransaction().commit();
			em.close();
			emf.close();
			
			response.getWriter().append("Pronto");
		}
		catch(ParseException e) {
			response.getWriter().append("Erro ao instanciar Data!");
		}
	}

}
