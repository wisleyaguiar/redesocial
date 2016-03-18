package dominio;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name="tb_album")
public class Album implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codAlbum;
	private String nome;
	
	@OneToMany(mappedBy="album")
	private List<Foto> fotos;
	
	@ManyToOne
	@JoinColumn(name="dono")
	private Usuario dono;
	
	//Construtor vazio
	public Album() {
		fotos = new ArrayList<>();
	}

	public Album(Integer codAlbum, String nome, Usuario dono) {
		super();
		this.codAlbum = codAlbum;
		this.nome = nome;
		fotos = new ArrayList<>();
		this.dono = dono;
		dono.addAlbum(this);
	}

	public Integer getCodAlbum() {
		return codAlbum;
	}

	public void setCodAlbum(Integer codAlbum) {
		this.codAlbum = codAlbum;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public Usuario getDono() {
		return dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
	}
	
	public void addFoto(Foto x){
		this.fotos.add(x);
		x.setAlbum(this);
	}
	
	public void removeFoto(Foto x){
		this.fotos.remove(x);
	}

	@Override
	public String toString() {
		return "Album [codAlbum=" + codAlbum + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAlbum == null) ? 0 : codAlbum.hashCode());
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
		Album other = (Album) obj;
		if (codAlbum == null) {
			if (other.codAlbum != null)
				return false;
		} else if (!codAlbum.equals(other.codAlbum))
			return false;
		return true;
	}
	
	public Foto maiorFoto() {
		Foto maiorFoto = this.fotos.get(0);
		for(Foto f: fotos) {
			if(maiorFoto.getTamanho() < f.getTamanho()) {
				maiorFoto = f;
			}
		}
		return maiorFoto;
	}
}