package dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_comentario")
public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codComentario;
	private Date data;
	private String conteudo;
	
	@ManyToOne
	@JoinColumn(name="postagem")
	private Postagem postagem;
	
	@ManyToOne
	@JoinColumn(name="autor")
	private Usuario autor;
	
	// Construtor Vazio
	public Comentario() {
	}

	public Comentario(Integer codComentario, Date data, String conteudo, Postagem postagem, Usuario autor) {
		super();
		this.codComentario = codComentario;
		this.data = data;
		this.conteudo = conteudo;
		this.postagem = postagem;
		postagem.addComentario(this);
		this.autor = autor;
		autor.addComentario(this);
	}

	public Integer getCodComentario() {
		return codComentario;
	}

	public void setCodComentario(Integer codComentario) {
		this.codComentario = codComentario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Postagem getPostagem() {
		return postagem;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Comentario [codComentario=" + codComentario + ", data=" + data + ", conteudo=" + conteudo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codComentario == null) ? 0 : codComentario.hashCode());
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
		Comentario other = (Comentario) obj;
		if (codComentario == null) {
			if (other.codComentario != null)
				return false;
		} else if (!codComentario.equals(other.codComentario))
			return false;
		return true;
	}
	
}
