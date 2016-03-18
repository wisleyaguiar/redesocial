package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codUsuario;
	private String nome;
	private String email;
	private String fone;
	private String senha;
	private Date nascimento;
	private BigDecimal salario;
	
	@OneToMany(mappedBy="dono")
	private List<Album> albuns;
	
	@OneToMany(mappedBy="autor")
	private List<Comentario> comentarios;
	
	@OneToMany(mappedBy="autor")
	private List<Postagem> postagens;
	
	@OneToMany(mappedBy="amigo")
	private List<Circulo> amigos;
	
	@OneToMany(mappedBy="seguidor")
	private List<Circulo> seguidores;
	
	// Construtor vazio
	public Usuario() {
		albuns = new ArrayList<>();
		comentarios = new ArrayList<>();
		postagens = new ArrayList<>();
		amigos = new ArrayList<>();
		seguidores = new ArrayList<>();
	}

	public Usuario(Integer codUsuario, String nome, String email, String fone, String senha, Date nascimento,
			BigDecimal salario) {
		super();
		this.codUsuario = codUsuario;
		this.nome = nome;
		this.email = email;
		this.fone = fone;
		this.senha = senha;
		this.nascimento = nascimento;
		this.salario = salario;
		albuns = new ArrayList<>();
		comentarios = new ArrayList<>();
		postagens = new ArrayList<>();
		amigos = new ArrayList<>();
		seguidores = new ArrayList<>();
	}

	public Integer getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(Integer codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public List<Album> getAlbuns() {
		return albuns;
	}

	public void setAlbuns(List<Album> albuns) {
		this.albuns = albuns;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}

	public List<Circulo> getAmigos() {
		return amigos;
	}

	public void setAmigos(List<Circulo> amigos) {
		this.amigos = amigos;
	}

	public List<Circulo> getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(List<Circulo> seguidores) {
		this.seguidores = seguidores;
	}
	
	public void addAlbum(Album x){
		this.albuns.add(x);
		x.setDono(this);
	}
	
	public void removeAlbum(Foto x){
		this.albuns.remove(x);
	}
	
	public void addComentario(Comentario x) {
		this.comentarios.add(x);
		x.setAutor(this);
	}
	
	public void removeComentario(Comentario x) {
		this.comentarios.remove(x);
	}
	
	public void addPostagem(Postagem x) {
		this.postagens.add(x);
		x.setAutor(this);
	}
	
	public void removePostagem(Postagem x) {
		this.postagens.remove(x);
	}
	
	public void addAmigo(Circulo x) {
		this.amigos.add(x);
		x.setAmigo(this);
	}
	
	public void addSeguidor(Circulo x) {
		this.seguidores.add(x);
		x.setSeguidor(this);
	}
	
	public void removeAmigo(Circulo x) {
		this.amigos.remove(x);
	}
	
	public void removeSeguidor(Circulo x) {
		this.seguidores.remove(x);
	}

	@Override
	public String toString() {
		return "Usuario [codUsuario=" + codUsuario + ", nome=" + nome + ", email=" + email + ", fone=" + fone
				+ ", senha=" + senha + ", nascimento=" + nascimento + ", salario=" + salario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codUsuario == null) ? 0 : codUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (codUsuario == null) {
			if (other.codUsuario != null)
				return false;
		} else if (!codUsuario.equals(other.codUsuario))
			return false;
		return true;
	}
	
	public List<Postagem> postagensNaoComentadas() {
		List<Postagem> naoComentadas = new ArrayList<>();
		for(Postagem p: postagens) {
			if(p.getComentarios().isEmpty()) {
				naoComentadas.add(p);
			}
		}
		return naoComentadas;
	}
	
}
