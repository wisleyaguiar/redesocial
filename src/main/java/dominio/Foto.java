package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_foto")
public class Foto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codFoto;
	private String nome;
	private String descricao;
	private Integer tamanho;
	
	@ManyToOne
	@JoinColumn(name="album")
	private Album album;
	
	//Construtor vazio
	public Foto() {
	}

	public Foto(Integer codFoto, String nome, String descricao, Integer tamanho, Album album) {
		super();
		this.codFoto = codFoto;
		this.nome = nome;
		this.descricao = descricao;
		this.tamanho = tamanho;
		this.album = album;
		album.addFoto(this);
	}

	public Integer getCodFoto() {
		return codFoto;
	}

	public void setCodFoto(Integer codFoto) {
		this.codFoto = codFoto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return "Foto [codFoto=" + codFoto + ", nome=" + nome + ", descricao=" + descricao + ", tamanho=" + tamanho
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codFoto == null) ? 0 : codFoto.hashCode());
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
		Foto other = (Foto) obj;
		if (codFoto == null) {
			if (other.codFoto != null)
				return false;
		} else if (!codFoto.equals(other.codFoto))
			return false;
		return true;
	}
	
	
}
