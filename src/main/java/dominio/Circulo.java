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
@Table(name="tb_circulo")
public class Circulo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codCirculo;
	private Date dataCriacao;
	
	@ManyToOne
	@JoinColumn(name="seguidor")
	private Usuario seguidor;
	
	@ManyToOne
	@JoinColumn(name="amigo")
	private Usuario amigo;
	
	//Construtor vazio
	public Circulo() {
	}

	public Circulo(Integer codCirculo, Date dataCriacao, Usuario seguidor, Usuario amigo) {
		super();
		this.codCirculo = codCirculo;
		this.dataCriacao = dataCriacao;
		this.seguidor = seguidor;
		seguidor.addAmigo(this);
		this.amigo = amigo;
		amigo.addSeguidor(this);
	}

	public Integer getCodCirculo() {
		return codCirculo;
	}

	public void setCodCirculo(Integer codCirculo) {
		this.codCirculo = codCirculo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Usuario getSeguidor() {
		return seguidor;
	}

	public void setSeguidor(Usuario seguidor) {
		this.seguidor = seguidor;
	}

	public Usuario getAmigo() {
		return amigo;
	}

	public void setAmigo(Usuario amigo) {
		this.amigo = amigo;
	}

	@Override
	public String toString() {
		return "Circulo [codCirculo=" + codCirculo + ", dataCriacao=" + dataCriacao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCirculo == null) ? 0 : codCirculo.hashCode());
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
		Circulo other = (Circulo) obj;
		if (codCirculo == null) {
			if (other.codCirculo != null)
				return false;
		} else if (!codCirculo.equals(other.codCirculo))
			return false;
		return true;
	}
	
}
