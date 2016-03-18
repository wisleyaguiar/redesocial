package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_postagem")
public class Postagem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codPostagem;
	private Date data;
	private String conteudo;
	
	@OneToMany(mappedBy="postagem")
	private List<Comentario> comentarios;
	
	@ManyToOne
	@JoinColumn(name="autor")
	private Usuario autor;
	
	// Construtor vazio
	public Postagem() {
		comentarios = new ArrayList<>();
	}

	public Postagem(Integer codPostagem, Date data, String conteudo, Usuario autor) {
		super();
		this.codPostagem = codPostagem;
		this.data = data;
		this.conteudo = conteudo;
		comentarios = new ArrayList<>();
		this.autor = autor;
		autor.addPostagem(this);
	}

	public Integer getCodPostagem() {
		return codPostagem;
	}

	public void setCodPostagem(Integer codPostagem) {
		this.codPostagem = codPostagem;
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

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	
	public void addComentario(Comentario x){
		this.comentarios.add(x);
		x.setPostagem(this);
	}
	
	public void removeComentario(Comentario x){
		this.comentarios.remove(x);
	}

	@Override
	public String toString() {
		return "Postagem [codPostagem=" + codPostagem + ", data=" + data + ", conteudo=" + conteudo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codPostagem == null) ? 0 : codPostagem.hashCode());
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
		Postagem other = (Postagem) obj;
		if (codPostagem == null) {
			if (other.codPostagem != null)
				return false;
		} else if (!codPostagem.equals(other.codPostagem))
			return false;
		return true;
	}
	
}
